package org.jsp.myrestaurant.controller;

import org.jsp.myrestaurant.dto.Hotel;
import org.jsp.myrestaurant.helper.LoginHelper;
import org.jsp.myrestaurant.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "hotel";
    }

    @GetMapping("/register")
    public String hotelRegister(ModelMap map) {
        map.put("hotel", hotel);
        return "hotelregister";
    }

    @PostMapping("/register")
    public String register(@Valid Hotel hotel, BindingResult result, ModelMap map) {
        if (result.hasErrors()) {
            return "hotelregister";
        }
        return hotelService.register(hotel, map);
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam int id, @RequestParam int otp, ModelMap map) {
        return hotelService.verify(id, otp, map);
    }

    @PostMapping("/login")

    public String login(LoginHelper helper, ModelMap map) {
        return hotelService.login(helper, map);
    }
}
