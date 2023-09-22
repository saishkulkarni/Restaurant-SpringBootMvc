package org.jsp.myrestaurant.repository;

import org.jsp.myrestaurant.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String email);

    Customer findByMobile(long mobile);

}
