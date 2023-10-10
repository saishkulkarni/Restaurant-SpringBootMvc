package org.jsp.myrestaurant.controller;

import org.jsp.myrestaurant.helper.LoginHelper;
import org.jsp.myrestaurant.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping
    public String adminLogin() {
        return "AdminLogin";
    }

    @GetMapping("/home")
    public String home() {
        return "AdminHome";
    }

    @PostMapping("/login")
    public String adminLogin(LoginHelper helper, ModelMap model, HttpSession session) {
        return adminService.login(helper, model, session);
    }

    @GetMapping("/products")
    public String getProducts(ModelMap model, HttpSession session) {
        String admin = (String) session.getAttribute("admin");
        if (admin != null) {
            return adminService.getItems(model, session);
        } else {
            model.put("neg", "Invalid Session");
            return "AdminLogin";
        }
    }

    @GetMapping("/hotels")
    private String getHotels(ModelMap model, HttpSession session) {
        String admin = (String) session.getAttribute("admin");
        if (admin != null) {
            return adminService.getHotels(model);
        } else {
            model.put("neg", "Invalid Session");
            return "AdminLogin";
        }
    }

    @GetMapping("/customers")
    public String getCustomers(ModelMap model, HttpSession session) {
        String admin = (String) session.getAttribute("admin");
        if (admin != null) {
            return adminService.getCustomers(model, session);
        } else {
            model.put("neg", "Invalid Session");
            return "AdminLogin";
        }
    }

    @GetMapping("/change-status/{id}")
    public String changeStatus(@PathVariable int id, ModelMap model, HttpSession session) {
        String admin = (String) session.getAttribute("admin");
        if (admin != null) {
            return adminService.changeStatus(id, model, session);
        } else {
            model.put("neg", "Invalid Session");
            return "AdminLogin";
        }
    }
}
