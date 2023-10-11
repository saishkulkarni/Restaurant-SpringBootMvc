package org.jsp.myrestaurant.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jsp.myrestaurant.dao.FoodItemDao;
import org.jsp.myrestaurant.dao.HotelDao;
import org.jsp.myrestaurant.dto.FoodItem;
import org.jsp.myrestaurant.dto.Hotel;
import org.jsp.myrestaurant.helper.AES;
import org.jsp.myrestaurant.helper.LoginHelper;
import org.jsp.myrestaurant.helper.SendMailLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Service
public class HotelService {
	@Autowired
	HotelDao hotelDao;

	@Autowired
	SendMailLogic mailLogic;

	@Autowired
	FoodItemDao foodItemDao;

	public String register(Hotel hotel, ModelMap map) {
		Hotel hotel1 = hotelDao.fetchByEmail(hotel.getEmail());
		Hotel hotel2 = hotelDao.fetchByPhone(hotel.getPhone());
		if (hotel1 == null && hotel2 == null) {
			int otp = new Random().nextInt(1000, 9999);
			hotel.setOtp(otp);
			// mailLogic.send(hotel);
			hotel.setPassword(AES.encrypt(hotel.getPassword(), "123"));
			hotelDao.save(hotel);
			map.put("id", hotel.getId());
			return "HotelVerifyOtp";

		} else {
			map.put("neg", "email and phone should not be repeated");
			return "HotelRegister";
		}

	}

	public String verify(int id, int otp, ModelMap map) {
		Hotel hotel = hotelDao.fetchById(id);
		if (hotel.getOtp() == otp) {
			hotel.setStatus(true);
			hotelDao.save(hotel);
			map.put("pos", "Otp verified successfully");
			return "HotelLogin";
		} else {
			map.put("neg", "otp mismatch");
			map.put("id", hotel.getId());
			return "HotelVerifyOtp";
		}

	}

	public String login(LoginHelper helper, ModelMap map, HttpSession session) {
		Hotel hotel = hotelDao.fetchByEmail(helper.getEmail());
		if (hotel == null) {
			map.put("neg", "invalid email");
			return "HotelLogin";
		} else {
			if (AES.decrypt(hotel.getPassword(), "123").equals(helper.getPassword())) {
				session.setAttribute("hotel", hotel);
				map.put("pos", "Loggedin successfully");
				return "HotelHome";
			} else {
				map.put("neg", "wrong password");
				return "HotelLogin";
			}
		}
	}

	public String addItem(FoodItem foodItem, MultipartFile image, Hotel hotel, ModelMap map, HttpSession session)
			throws IOException {

		byte[] picture = new byte[image.getInputStream().available()];
		image.getInputStream().read(picture);

		foodItem.setPicture(picture);
		List<FoodItem> list = hotel.getItems();
		if (list == null)
			list = new ArrayList<FoodItem>();
		list.add(foodItem);
		hotel.setItems(list);
		hotelDao.save(hotel);

		session.setAttribute("hotel", hotelDao.fetchById(hotel.getId()));
		map.put("pos", "Item added successfully");
		return "HotelHome";
	}

	public String fetchItems(Hotel hotel, HttpSession session, ModelMap map) {
		List<FoodItem> items = hotel.getItems();
		if (items == null || items.isEmpty()) {
			map.put("neg", "no items");
			return "HotelHome";
		} else {
			map.put("items", items);
			return "HotelItems";
		}
	}

	public String deleteProduct(int id, Hotel hotel, HttpSession session, ModelMap map) {
		FoodItem item = foodItemDao.findById(id);
		if (item != null) {
			hotel.getItems().remove(item);
			hotelDao.save(hotel);

			foodItemDao.delete(item);

			map.put("pos", "Data Deleted Successfully");
			session.setAttribute("hotel", hotelDao.fetchById(hotel.getId()));
			return fetchItems(hotelDao.fetchById(hotel.getId()), session, map);

		} else {
			map.put("neg", "Something Went Wrong");
			return "Main";
		}
	}

	public String editProduct(int id, Hotel hotel, HttpSession session, ModelMap map) {
		FoodItem item = foodItemDao.findById(id);
		if (item != null) {
			map.put("item", item);
			return "EditItem";
		} else {
			map.put("neg", "Something Went Wrong");
			return "Main";
		}
	}

	public String updateItem(FoodItem foodItem, MultipartFile image, Hotel hotel, ModelMap map, HttpSession session)
			throws IOException {

		byte[] picture = new byte[image.getInputStream().available()];
		image.getInputStream().read(picture);

		if (picture.length == 0)
			foodItem.setPicture(foodItemDao.findById(foodItem.getId()).getPicture());
		else
			foodItem.setPicture(picture);

		foodItemDao.save(foodItem);

		session.setAttribute("hotel", hotelDao.fetchById(hotel.getId()));
		map.put("pos", "Item Updated successfully");
		return fetchItems(hotelDao.fetchById(hotel.getId()), session, map);

	}

	public String editItem(FoodItem foodItem, HttpSession session, MultipartFile image, Hotel hotel, ModelMap map)
			throws IOException {
		byte[] picture = new byte[image.getInputStream().available()];
		image.getInputStream().read(picture);

		if (picture.length == 0) {
			foodItem.setPicture(foodItemDao.findById(foodItem.getId()).getPicture());
		} else {
			foodItem.setPicture(picture);
		}
		foodItemDao.save(foodItem);
		map.put("pos", "Item Updated successfully");
		session.setAttribute("hotel", hotelDao.fetchById(hotel.getId()));
		return fetchItems(hotelDao.fetchById(hotel.getId()), session, map);
	}
}
