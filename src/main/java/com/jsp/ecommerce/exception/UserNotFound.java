package com.jsp.ecommerce.exception;

public class UserNotFound extends NotFoundException {
    public UserNotFound(String message) {
        super(message);
    }
}
