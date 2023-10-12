package org.jsp.myrestaurant.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    LocalDateTime dateTime;
    double price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<CustomerFood> list;

}
