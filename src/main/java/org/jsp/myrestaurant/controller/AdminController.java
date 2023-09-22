package org.jsp.myrestaurant.controller;

import org.jsp.myrestaurant.helper.LoginHelper;
import org.jsp.myrestaurant.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/login")
    public String adminLogin(LoginHelper helper, ModelMap model, HttpSession session) {
        return adminService.login(helper, model, session);
    }
}
