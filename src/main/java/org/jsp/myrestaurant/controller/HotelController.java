package org.jsp.myrestaurant.controller;

import java.io.IOException;

import org.jsp.myrestaurant.dto.FoodItem;
import org.jsp.myrestaurant.dto.Hotel;
import org.jsp.myrestaurant.helper.LoginHelper;
import org.jsp.myrestaurant.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RequestMapping("/hotel")
@Controller
@Component
public class HotelController {
	@Autowired
	Hotel hotel;

	@Autowired
	HotelService hotelService;

	@GetMapping
	public String hotelLogin() {
		return "HotelLogin";
	}

	@GetMapping("/register")
	public String hotelRegister(ModelMap map) {
		map.put("hotel", hotel);
		return "HotelRegister";
	}

	@PostMapping("/register")
	public String register(@Valid Hotel hotel, BindingResult result, ModelMap map) {
		if (result.hasErrors()) {
			return "HotelRegister";
		}
		return hotelService.register(hotel, map);
	}

	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam int id, @RequestParam int otp, ModelMap map) {
		return hotelService.verify(id, otp, map);
	}

	@PostMapping("/login")
	public String login(LoginHelper helper, ModelMap map, HttpSession session) {
		return hotelService.login(helper, map, session);
	}

	@GetMapping("/add-item")
	public String addItem(HttpSession session, ModelMap map) {
		Hotel hotel = (Hotel) session.getAttribute("hotel");
		if (hotel != null) {
			return "AddItem";
		} else {
			map.put("neg", "Invalid Session");
			return "HotelLogin";
		}
	}

	@PostMapping("/add-item")
	public String addItem(FoodItem foodItem, @RequestParam MultipartFile image, HttpSession session, ModelMap map)
			throws IOException {
		Hotel hotel = (Hotel) session.getAttribute("hotel");
		if (hotel != null) {
			return hotelService.addItem(foodItem, image, hotel, map,session);
		} else {
			map.put("neg", "Invalid Session");
			return "HotelLogin";
		}
	}

	@GetMapping("/fetch-items")
	public String fetchItems(HttpSession session, ModelMap map) {
		Hotel hotel = (Hotel) session.getAttribute("hotel");
		if (hotel != null) {
			return hotelService.fetchItems(hotel, session, map);
		} else {
			map.put("neg", "Invalid Session");
			return "HotelLogin";
		}
	}

	@GetMapping("/home")
	public String home(HttpSession session, ModelMap map) {
		Hotel hotel = (Hotel) session.getAttribute("hotel");
		if (hotel != null) {
			return "HotelHome";
		} else {
			map.put("neg", "Invalid Session");
			return "HotelLogin";
		}
	}
	
    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable int id, HttpSession session, ModelMap map) {
        Hotel hotel = (Hotel) session.getAttribute("hotel");
        if (hotel != null) {
            return hotelService.deleteProduct(id, hotel, session, map);
        } else {
            map.put("neg", "Invalid Session");
            return "HotelLogin";
        }
    }
    
}