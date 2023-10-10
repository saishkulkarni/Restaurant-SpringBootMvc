package org.jsp.myrestaurant.repository;

import java.util.List;

import org.jsp.myrestaurant.dto.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>
{

	List<FoodItem> findByStatusTrue();
    
}
