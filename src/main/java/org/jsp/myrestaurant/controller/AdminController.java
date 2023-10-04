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

	@PostMapping("/login")
	public String adminLogin(LoginHelper helper, ModelMap model, HttpSession session) {
		return adminService.login(helper, model, session);
	}

	@GetMapping("/fetch-items")
	public String fetchItems(HttpSession session, ModelMap map) {
		String admin = (String) session.getAttribute("admin");
		if (admin != null) {
			return adminService.fetchItems(session, map);
		} else {
			map.put("neg", "Invalid Session");
			return "HotelLogin";
		}
	}

	@GetMapping("/home")
	public String loadHome(HttpSession session, ModelMap map) {
		String admin = (String) session.getAttribute("admin");
		if (admin != null) {
			return "AdminHome";
		} else {
			map.put("neg", "Invalid Session");
			return "HotelLogin";
		}
	}

	@GetMapping("/product-status/{id}")
	public String changeStatus(@PathVariable int id, HttpSession session, ModelMap map) {
		String admin = (String) session.getAttribute("admin");
		if (admin != null) {
			return adminService.changeStatus(id, session, map);
		} else {
			map.put("neg", "Invalid Session");
			return "HotelLogin";
		}
	}

	@GetMapping("/fetch-hotels")
	public String fetchHotels(HttpSession session, ModelMap map) {
		String admin = (String) session.getAttribute("admin");
		if (admin != null) {
			return adminService.fetchHotels(session, map);
		} else {
			map.put("neg", "Invalid Session");
			return "HotelLogin";
		}
	}

	@GetMapping("/fetch-customers")
	public String fetchCustomers(HttpSession session, ModelMap map) {
		String admin = (String) session.getAttribute("admin");
		if (admin != null) {
			return adminService.fetchCustomers(session, map);
		} else {
			map.put("neg", "Invalid Session");
			return "HotelLogin";
		}
	}
}
