package com.jsp.ecommerce.dto;

import lombok.Data;

@Data
public class AddressUpdateReq {
    private long id;
    private String street;
    private String city;
    private String state;

    private int pincode;
    private String country;
    private boolean isDefault;

}
