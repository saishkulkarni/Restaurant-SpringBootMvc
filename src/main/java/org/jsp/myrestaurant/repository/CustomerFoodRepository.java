package org.jsp.myrestaurant.repository;

import org.jsp.myrestaurant.dto.CustomerFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerFoodRepository extends JpaRepository<CustomerFood, Integer> {

}
