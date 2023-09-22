package org.jsp.myrestaurant.repository;

import org.jsp.myrestaurant.dto.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    Hotel findByEmail(String email);

    Hotel findByPhone(long phone);

}