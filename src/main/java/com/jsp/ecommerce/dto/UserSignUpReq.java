package com.jsp.ecommerce.dto;

import com.jsp.ecommerce.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserSignUpReq {
    private String name;
    @Email(message = "Please enter a valid Email Id")
    private String email;
    @NotBlank
    private String password;
    @Digits(integer = 10, fraction = 0,message = "only 10 Digit Phone No. allowed")
    private long phone;
}
