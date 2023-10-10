package org.jsp.myrestaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/")
	public String loadMain() {
		return "Main";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.put("neg", "Logout Success");
		return "Main";
	}

}
