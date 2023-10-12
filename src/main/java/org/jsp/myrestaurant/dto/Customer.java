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
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Component
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 5, message = "*Enter Words between 5 to 20")
    private String name;
    @Email(message = "*Enter proper email Id")
    @NotEmpty(message = "*This field should not be empty")
    private String email;
    @DecimalMin(value = "6000000000")
    @DecimalMax(value = "9999999999", message = "Enter The Phone No")
    private long mobile;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    private String password;
    private boolean status;
    private int otp;

    @OneToOne(cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<CustomerOrder> orders;
}
