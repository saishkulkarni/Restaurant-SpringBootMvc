package org.jsp.myrestaurant.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Component
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 5, max = 20, message = "*enter characters between 5-20")
    // size will work only for String
    private String name;
    @Email(message = "*enter proper email id")
    @NotNull(message = "*This field shouldn't be empty")
    private String email;
    @DecimalMax(value = "9999999999", message = "*enter proper mobile number")
    @DecimalMin(value = "6000000000", message = "*enter proper mobile number")
    private long phone;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "*password must contain atleast one uppercase,one lowercase and one number")
    private String password;
    private boolean status;
    private int otp;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<FoodItem> items;
}
