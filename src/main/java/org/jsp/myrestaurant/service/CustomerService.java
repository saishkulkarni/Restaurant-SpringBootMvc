package org.jsp.myrestaurant.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONObject;
import org.jsp.myrestaurant.dao.CustomerDao;
import org.jsp.myrestaurant.dao.FoodItemDao;
import org.jsp.myrestaurant.dto.Cart;
import org.jsp.myrestaurant.dto.Customer;
import org.jsp.myrestaurant.dto.CustomerFood;
import org.jsp.myrestaurant.dto.CustomerOrder;
import org.jsp.myrestaurant.dto.FoodItem;
import org.jsp.myrestaurant.dto.PaymentDetails;
import org.jsp.myrestaurant.helper.AES;
import org.jsp.myrestaurant.helper.LoginHelper;
import org.jsp.myrestaurant.helper.SendMailLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.servlet.http.HttpSession;

@Service
@Component
public class CustomerService {

    @Autowired
    CustomerDao dao;

    @Autowired
    SendMailLogic logic;

    @Autowired
    FoodItemDao foodItemDao;

    public String signup(Customer customer, ModelMap map) {
        Customer customer1 = dao.fetchByEmail(customer.getEmail());
        Customer customer2 = dao.fetchByMobile(customer.getMobile());
        if (customer1 == null && customer2 == null) {
            int otp = new Random().nextInt(100000, 999999);
            customer.setOtp(otp);
            // logic.send(customer);
            customer.setPassword(AES.encrypt(customer.getPassword(), "123"));
            dao.save(customer);
            map.put("id", customer.getId());
            return "CustomerVerifyOtp";
        } else {
            map.put("neg", "Email and Phone Number Should not be repeated");
            return "CustomerSignup";
        }
    }

    public String verifyOtp(int id, int otp, ModelMap map) {
        Customer customer = dao.fetchById(id);
        if (customer.getOtp() == otp) {
            customer.setStatus(true);
            dao.save(customer);
            map.put("pos", "Otp verify Successfully");
            return "CustomerLogin";
        } else {
            map.put("neg", "Otp mismatch");
            map.put("id", customer.getId());
            return "CustomerVerifyOtp";
        }
    }

    public String login(LoginHelper helper, ModelMap map, HttpSession httpSession) {
        Customer customer = dao.fetchByEmail(helper.getEmail());
        if (customer == null) {
            map.put("neg", "Invalid Email");
            return "CustomerLogin";
        } else if (AES.decrypt(customer.getPassword(), "123").equals(helper.getPassword())) {
            map.put("pos", "Login Success");
            httpSession.setAttribute("customer", customer);
            return "CustomerHome";
        } else {
            map.put("neg", "Invalid Password");
            return "CustomerLogin";
        }
    }

    public String fetchItems(HttpSession session, ModelMap map) {
        List<FoodItem> items = foodItemDao.fetchAllApproved();
        if (items == null || items.isEmpty()) {
            map.put("neg", "no items");
            return "CustomerHome";
        } else {
            map.put("items", items);
            Customer customer = (Customer) session.getAttribute("customer");
            Cart cart = customer.getCart();
            if (cart == null)
                map.put("cartItems", null);
            else
                map.put("cartItems", cart.getFoods());
            return "CustomerItems";
        }
    }

    public String addToCart(int id, Customer customer, ModelMap map, HttpSession session) {
        FoodItem item = foodItemDao.findById(id);
        if (item != null) {
            if (item.getStock() > 0) {
                Cart cart = customer.getCart();
                if (cart == null)
                    cart = new Cart();
                List<CustomerFood> list = cart.getFoods();
                if (list == null) {
                    list = new ArrayList<CustomerFood>();
                    cart.setFoods(list);
                }
                boolean flag = true;
                for (CustomerFood food : list) {
                    if (food.getName().equals(item.getName())) {
                        food.setQuantity(food.getQuantity() + 1);
                        food.setPrice(food.getPrice() + item.getPrice());
                        flag = false;
                    }
                }

                if (flag) {
                    CustomerFood food = new CustomerFood();
                    food.setQuantity(1);
                    food.setDescription(item.getDescription());
                    food.setPrice(item.getPrice());
                    food.setPicture(item.getPicture());
                    food.setName(item.getName());
                    cart.getFoods().add(food);
                }
                item.setStock(item.getStock() - 1);
                foodItemDao.save(item);
                customer.setCart(cart);
                dao.save(customer);
                session.setAttribute("customer", dao.fetchById(customer.getId()));
                map.put("pos", "Added Successfully");
                return fetchItems(session, map);

            } else {
                map.put("neg", "Out of Stock");
                return fetchItems(session, map);
            }
        } else {
            map.put("neg", "Something went wrong");
            return "Main";
        }
    }

    public String removeFromCart(int id, Customer customer, ModelMap map, HttpSession session) {
        FoodItem item = foodItemDao.findById(id);
        if (item != null) {
            Cart cart = customer.getCart();
            if (cart == null) {
                map.put("neg", "No Items in Cart");
                return fetchItems(session, map);
            } else {
                List<CustomerFood> list = cart.getFoods();
                if (list == null) {
                    map.put("neg", "No Items in Cart");
                    return fetchItems(session, map);
                } else {
                    CustomerFood customerFood = null;
                    for (CustomerFood customerFood2 : list) {
                        if (item.getName().equals(customerFood2.getName())) {
                            customerFood = customerFood2;
                            break;
                        }
                    }
                    if (customerFood == null) {
                        map.put("neg", "No Items in Cart");
                        return fetchItems(session, map);
                    } else {
                        if (customerFood.getQuantity() > 1) {
                            customerFood.setQuantity(customerFood.getQuantity() - 1);
                            customerFood.setPrice(customerFood.getPrice() - item.getPrice());
                            item.setStock(item.getStock() + 1);
                            foodItemDao.save(item);
                            foodItemDao.save(customerFood);
                        } else {
                            list.remove(customerFood);
                            item.setStock(item.getStock() + 1);
                            foodItemDao.save(item);
                            foodItemDao.save(cart);
                            foodItemDao.delete(customerFood);
                        }
                        map.put("pos", "Item removed from Cart");
                        session.setAttribute("customer", dao.fetchById(customer.getId()));
                        return fetchItems(session, map);
                    }
                }
            }
        } else {
            map.put("neg", "Something went wrong");
            return "Main";
        }
    }

    public String viewCart(HttpSession session, Customer customer, ModelMap map) throws RazorpayException {
        Cart cart = customer.getCart();
        if (cart == null) {
            map.put("neg", "No Items in Cart");
            return fetchItems(session, map);
        } else {
            List<CustomerFood> list = cart.getFoods();
            if (list == null || list.isEmpty()) {
                map.put("neg", "No Items in Cart");
                return fetchItems(session, map);
            } else {
                boolean flag = true;
                for (CustomerFood customerFood : list) {
                    if (customerFood.getQuantity() > 0)
                        flag = false;
                    break;
                }
                if (flag) {
                    map.put("neg", "No Items in Cart");
                    return fetchItems(session, map);
                } else {
                    double amount = 0;
                    for (CustomerFood customerFood : list) {
                        amount = amount + customerFood.getPrice();
                    }

                    JSONObject object = new JSONObject();
                    object.put("amount", (int) (amount * 100));
                    object.put("currency", "INR");

                    RazorpayClient client = new RazorpayClient("rzp_test_pXzztvFSoP8U0y", "CSRywILSxpj4nnthtfisyY57");
                    Order order = client.orders.create(object);
                    PaymentDetails details = new PaymentDetails();
                    details.setAmount(order.get("amount").toString());
                    details.setCurrency(order.get("currency").toString());
                    details.setPaymentId(null);
                    details.setOrderId(order.get("id").toString());
                    details.setStatus(order.get("status"));
                    details.setKeyDetails("rzp_test_pXzztvFSoP8U0y");

                    session.setAttribute("customer", dao.fetchById(customer.getId()));
                    map.put("details", foodItemDao.saveDetails(details));
                    map.put("items", list);
                    map.put("customer", dao.fetchById(customer.getId()));
                    return "ViewCart";
                }
            }
        }
    }

    public String checkPayment(String payment_id, HttpSession session, int id, Customer customer, ModelMap modelMap) {
        if (payment_id != null) {
            PaymentDetails details = foodItemDao.fetchDetails(id);
            details.setPaymentId(payment_id);
            details.setStatus("Success");
            foodItemDao.saveDetails(details);

            List<CustomerOrder> orders = customer.getOrders();
            if (orders == null)
                orders = new ArrayList<CustomerOrder>();
            CustomerOrder customerOrder = new CustomerOrder();
            customerOrder.setDateTime(LocalDateTime.now());
            customerOrder.setPrice(Double.parseDouble(details.getAmount()) / 100);
            customerOrder.setList(customer.getCart().getFoods());

            orders.add(customerOrder);
            customer.setOrders(orders);
            customer.setCart(null);
            dao.save(customer);
            session.setAttribute("customer", dao.fetchById(customer.getId()));
            modelMap.put("pos", "Order Placed Success");
            return "CustomerHome";
        } else {
            modelMap.put("neg", "Payment Not Done");
            return "CustomerHome";
        }
    }

    public String fetchOrders(ModelMap modelMap, HttpSession session, Customer customer) {
        List<CustomerOrder> orders = customer.getOrders();
        if (orders == null || orders.isEmpty()) {
            modelMap.put("neg", "No Orders Found");
            return "CustomerHome";
        } else {
            modelMap.put("orders", orders);
            return "CustomerOrders";
        }
    }

}
