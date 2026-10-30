package com.jsp.ecommerce.dto;

import com.jsp.ecommerce.entity.User;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressCreationReq {
    private String street;
    private String city;
    private String state;
    private int pincode;
    private String country;
    private boolean isDefault;

    private long userId;
}
