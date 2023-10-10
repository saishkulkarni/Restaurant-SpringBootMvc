package org.jsp.myrestaurant.service;

import java.util.List;

import org.jsp.myrestaurant.dao.CustomerDao;
import org.jsp.myrestaurant.dao.FoodItemDao;
import org.jsp.myrestaurant.dao.HotelDao;
import org.jsp.myrestaurant.dto.Customer;
import org.jsp.myrestaurant.dto.FoodItem;
import org.jsp.myrestaurant.dto.Hotel;
import org.jsp.myrestaurant.helper.LoginHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {

    @Autowired
    FoodItemDao foodItemDao;

    @Autowired
    HotelDao hotelDao;

    @Autowired
    CustomerDao customerDao;

    public String login(LoginHelper helper, ModelMap model, HttpSession session) {
        if (helper.getEmail().equals("admin@jsp.com")) {
            if (helper.getPassword().equals("admin")) {
                session.setAttribute("admin", "admin");
                model.put("pass", "Login Success");
                return "AdminHome";
            } else {
                model.put("fail", "Incorrect Password");
                return "AdminLogin";
            }
        } else {
            model.put("fail", "Incorrect Email");
            return "AdminLogin";
        }
    }

    public String getItems(ModelMap model, HttpSession session) {
        List<FoodItem> list = foodItemDao.findAll();
        if (list.isEmpty()) {
            model.put("neg", "No Data Found");
            return "AdminHome";
        } else {
            model.put("list", list);
            return "AdminItems";
        }
    }

    public String getHotels(ModelMap model) {
        List<Hotel> list = hotelDao.findAll();
        if (list.isEmpty()) {
            model.put("neg", "No Data Found");
            return "AdminHome";
        } else {
            model.put("list", list);
            return "AdminHotels";
        }
    }

    public String getCustomers(ModelMap model, HttpSession session) {
        List<Customer> list = customerDao.findAll();
        if (list.isEmpty()) {
            model.put("neg", "No Data Found");
            return "AdminHome";
        } else {
            model.put("list", list);
            return "AdminCustomers";
        }
    }

    public String changeStatus(int id, ModelMap model, HttpSession session) {
        FoodItem item = foodItemDao.findById(id);
        if (item != null) {
            if (item.isStatus())
                item.setStatus(false);
            else
                item.setStatus(true);

            foodItemDao.save(item);

            model.put("pos", "Status Changed Successfully");
            return getItems(model, session);
        } else {
            model.put("neg", "Something Went Wrong");
            return "Main";
        }
    }

}
