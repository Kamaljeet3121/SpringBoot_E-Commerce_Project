package com.jsp.ecommerce.entity;

import com.jsp.ecommerce.repository.AddressRepository;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseStructure<T> {
    private String message;
    private LocalDateTime timestamp;
    private String path;
    private T data;
    public ResponseStructure(String message,T data,String path) {
        timestamp = LocalDateTime.now();
        this.data = data;
        this.message = message;
        this.path = path;

    }

}
