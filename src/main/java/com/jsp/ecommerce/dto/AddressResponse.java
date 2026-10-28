package com.jsp.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"id","street","City","state","country"})
public class AddressResponse {
    private long id;
    private String street;
    private String city;
    private String state;
    private int pincode;
    private String country;
    private UserResponse user;
}
