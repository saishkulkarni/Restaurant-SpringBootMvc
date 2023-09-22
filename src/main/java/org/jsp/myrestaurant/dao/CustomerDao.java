package org.jsp.myrestaurant.dao;

import org.jsp.myrestaurant.dto.Customer;
import org.jsp.myrestaurant.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

    @Autowired
    CustomerRepository repository;

    public Customer fetchByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Customer fetchByMobile(long mobile) {
        return repository.findByMobile(mobile);
    }

    public void save(Customer customer) {
        repository.save(customer);
    }

    public Customer fetchById(int id) {
        return repository.findById(id).orElse(null);
    }

}
