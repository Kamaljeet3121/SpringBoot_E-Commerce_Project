package com.jsp.ecommerce.dto;

import com.jsp.ecommerce.entity.User;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddressCreationReq {
    @NotBlank(message ="Empty Street Not allowed")
    private String street;
    @NotBlank(message ="Empty city Not allowed")
    private String city;
    @NotBlank(message ="Empty state Not allowed")
    private String state;

    @Digits(integer = 6,message = "Enter 6 Digit Pin-code", fraction = 0)
    private int pincode;
    @NotBlank(message ="Empty country Not allowed")
    private String country;

    @NotNull
    private long userId;
}
