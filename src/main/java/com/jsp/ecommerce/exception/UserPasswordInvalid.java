package com.jsp.ecommerce.exception;

public class UserPasswordInvalid extends RuntimeException {
    public UserPasswordInvalid(String message) {
        super(message);
    }
}
