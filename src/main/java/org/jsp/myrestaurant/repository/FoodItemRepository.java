package org.jsp.myrestaurant.repository;

import org.jsp.myrestaurant.dto.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>
{
    
}
