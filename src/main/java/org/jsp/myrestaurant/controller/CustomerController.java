package org.jsp.myrestaurant.controller;

import org.jsp.myrestaurant.dto.Customer;
import org.jsp.myrestaurant.helper.LoginHelper;
import org.jsp.myrestaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.razorpay.RazorpayException;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    Customer customer;

    @Autowired
    CustomerService customerService;

    @GetMapping
    public String customer() {
        return "CustomerLogin";
    }

    @GetMapping("/signup")
    public String loadSign(ModelMap map) {
        map.put("customer", customer);
        return "CustomerSignup";
    }

    @PostMapping("/signup")
    public String signup(@Valid Customer customer, BindingResult result, ModelMap map) {
        if (result.hasErrors()) {
            return "CustomerSignup";
        } else {
            return customerService.signup(customer, map);
        }
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam int id, @RequestParam int otp, ModelMap map) {
        return customerService.verifyOtp(id, otp, map);
    }

    @PostMapping("login")
    public String login(LoginHelper helper, ModelMap map,HttpSession httpSession) {
        return customerService.login(helper, map,httpSession);
    }
    
    @GetMapping("/fetch-items")
	public String fetchItems(HttpSession session, ModelMap map) {
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer!= null) {
			return customerService.fetchItems(session, map);
		} else {
			map.put("neg", "Invalid Session");
			return "CustomerLogin";
		}
	}
    
    @GetMapping("/home")
    public String loadHome(HttpSession session, ModelMap map)
    {
    	Customer customer = (Customer) session.getAttribute("customer");
		if (customer!= null) {
			return "CustomerHome";
		} else {
			map.put("neg", "Invalid Session");
			return "CustomerLogin";
		}
    }

    @GetMapping("/cart-add/{id}")
    public String addToCart(@PathVariable int id,HttpSession session,ModelMap map) {
          Customer customer = (Customer) session.getAttribute("customer");
		if (customer!= null) {
			return customerService.addToCart(id,customer,map,session);
		} else {
			map.put("neg", "Invalid Session");
			return "CustomerLogin";
		}  
    }

    @GetMapping("/cart-remove/{id}")
    public String removeFromCart(@PathVariable int id,HttpSession session,ModelMap map) {
          Customer customer = (Customer) session.getAttribute("customer");
		if (customer!= null) {
			return customerService.removeFromCart(id,customer,map,session);
		} else {
			map.put("neg", "Invalid Session");
			return "CustomerLogin";
		}  
    }

    @GetMapping("/viewcart")
	public String viewCart(HttpSession session, ModelMap modelMap) throws RazorpayException {
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {
			return customerService.viewCart(session, customer, modelMap);
		} else {
			modelMap.put("neg", "Invalid Session");
			return "Main";
		}
	}

    @PostMapping("/payment/{id}")
    public String checkPayment(@RequestParam String razorpay_payment_id,@PathVariable int id,ModelMap modelMap,HttpSession session) {
    Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {
			return customerService.checkPayment(razorpay_payment_id,session,id, customer, modelMap);
		} else {
			modelMap.put("neg", "Invalid Session");
			return "Main";
		}
    }

    @GetMapping("/fetch-orders")
    public String fetchOrders(HttpSession session, ModelMap modelMap){
         Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {
			return customerService.fetchOrders(modelMap,session,customer);
		} else {
			modelMap.put("neg", "Invalid Session");
			return "Main";
		}
    }
}
