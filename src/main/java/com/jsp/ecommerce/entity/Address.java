package com.jsp.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "add_sequence")
    @SequenceGenerator(name="add_sequence",initialValue = 20, allocationSize=1)
    private long id;
    private String street;
    private String city;
    private String state;
    private int pincode;
    private String country;
    private boolean isDefault;

    @ManyToOne
    private User user;
}
