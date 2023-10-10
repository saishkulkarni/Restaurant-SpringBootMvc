package org.jsp.myrestaurant.dao;

import java.util.List;

import org.jsp.myrestaurant.dto.Hotel;
import org.jsp.myrestaurant.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDao {
    @Autowired
    HotelRepository hotelRepository;

    public Hotel fetchByEmail(String email) {
        return hotelRepository.findByEmail(email);
    }

    public Hotel fetchByPhone(long phone) {
        return hotelRepository.findByPhone(phone);
    }

    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public Hotel fetchById(int id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

}
