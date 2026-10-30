package com.jsp.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginReq {
    @Email
    private String email;
    private String password;
    private Long phone;
}
