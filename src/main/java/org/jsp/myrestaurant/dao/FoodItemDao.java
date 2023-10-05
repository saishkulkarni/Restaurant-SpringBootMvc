package org.jsp.myrestaurant.dao;

import java.util.List;

import org.jsp.myrestaurant.dto.FoodItem;
import org.jsp.myrestaurant.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodItemDao {
	@Autowired
	FoodItemRepository foodItemRepository;

	public FoodItem fetchById(int id) {
		return foodItemRepository.findById(id).orElse(null);
	}

	public void delete(FoodItem foodItem) {
		foodItemRepository.delete(foodItem);
	}

	public void save(FoodItem foodItem) {
		foodItemRepository.save(foodItem);
	}

	public List<FoodItem> fetchAll() {
		return foodItemRepository.findAll();
	}
}
