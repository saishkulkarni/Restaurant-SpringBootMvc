package org.jsp.myrestaurant.repository;

import org.jsp.myrestaurant.dto.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
