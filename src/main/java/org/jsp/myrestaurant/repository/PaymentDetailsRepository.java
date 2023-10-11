package org.jsp.myrestaurant.repository;

import org.jsp.myrestaurant.dto.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Integer> {

}
