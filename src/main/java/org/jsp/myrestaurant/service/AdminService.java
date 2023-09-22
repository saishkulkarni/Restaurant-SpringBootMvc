package org.jsp.myrestaurant.service;

import org.jsp.myrestaurant.helper.LoginHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {

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

}
