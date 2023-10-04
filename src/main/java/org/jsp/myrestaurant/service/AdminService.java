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

	public String fetchItems(HttpSession session, ModelMap map) {
		List<FoodItem> items = foodItemDao.fetchAll();
		if (items == null || items.isEmpty()) {
			map.put("neg", "no items");
			return "AdminHome";
		} else {
			map.put("items", items);
			return "AdminItems";
		}
	}

	public String changeStatus(int id, HttpSession session, ModelMap map) {
		FoodItem foodItem = foodItemDao.fetchById(id);
		if (foodItem == null) {
			map.put("neg", "Something went wrong");
			return "Main";
		} else {
			if (foodItem.isStatus())
				foodItem.setStatus(false);
			else
				foodItem.setStatus(true);

			foodItemDao.save(foodItem);
			map.put("pos", "Status Changed Success");
			return fetchItems(session, map);
		}
	}

	public String fetchHotels(HttpSession session, ModelMap map) {
		List<Hotel> hotels = hotelDao.fetchAll();
		if (hotels == null || hotels.isEmpty()) {
			map.put("neg", "no hotels");
			return "AdminHome";
		} else {
			map.put("hotels", hotels);
			return "AdminHotels";
		}
	}

	public String fetchCustomers(HttpSession session, ModelMap map) {
		List<Customer> customers = customerDao.fetchAll();
		if (customers == null || customers.isEmpty()) {
			map.put("neg", "no customers");
			return "AdminHome";
		} else {
			map.put("customers", customers);
			return "AdminCustomers";
		}
	}

}
