package com.jsp.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jsp.ecommerce.enums.Role;
import lombok.Data;

@Data
@JsonPropertyOrder({"id","name","email"})
public class UserResponse {

    private long id;
    private String name;
    private String email;
    private Role role;
    private long phone;
}
