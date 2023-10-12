package org.jsp.myrestaurant.dao;

import java.util.List;

import org.jsp.myrestaurant.dto.Cart;
import org.jsp.myrestaurant.dto.CustomerFood;
import org.jsp.myrestaurant.dto.FoodItem;
import org.jsp.myrestaurant.dto.PaymentDetails;
import org.jsp.myrestaurant.repository.CartRepository;
import org.jsp.myrestaurant.repository.CustomerFoodRepository;
import org.jsp.myrestaurant.repository.FoodItemRepository;
import org.jsp.myrestaurant.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodItemDao {

    @Autowired
    FoodItemRepository foodItemRepository;

    @Autowired
    CustomerFoodRepository foodRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    PaymentDetailsRepository detailsRepository;

    public FoodItem findById(int id) {
        return foodItemRepository.findById(id).orElse(null);
    }

    public void delete(FoodItem item) {
        foodItemRepository.delete(item);
    }

    public void save(FoodItem foodItem) {
        foodItemRepository.save(foodItem);
    }

    public List<FoodItem> findAll() {
        return foodItemRepository.findAll();
    }

    public List<FoodItem> fetchAllApproved() {
        return foodItemRepository.findByStatusTrue();
    }

    public void save(CustomerFood customerFood) {
        foodRepository.save(customerFood);
    }

    public void delete(CustomerFood customerFood) {
        foodRepository.delete(customerFood);
    }

    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    public PaymentDetails saveDetails(PaymentDetails details) {
        return detailsRepository.save(details);
    }

     public PaymentDetails fetchDetails(int id) {
        return detailsRepository.findById(id).orElse(null);
    }

}
