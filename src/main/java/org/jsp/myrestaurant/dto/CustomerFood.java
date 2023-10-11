package org.jsp.myrestaurant.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class CustomerFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] picture;
    private int quantity;
}
