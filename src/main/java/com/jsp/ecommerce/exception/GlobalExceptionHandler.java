package com.jsp.ecommerce.exception;

import com.jsp.ecommerce.entity.ResponseStructure;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> NotFound(NotFoundException ex, HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseStructure<>("Exception Occurred",ex.getMessage(),request.getRequestURI()));

    }

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<ResponseStructure<String>> NotFound(UserAlreadyExists ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ResponseStructure<>("Exception Occurred",ex.getMessage(),request.getRequestURI()));

    }

    @ExceptionHandler(UserPasswordInvalid.class)
    public ResponseEntity<ResponseStructure<String>> NotFound(UserPasswordInvalid ex, HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ResponseStructure<>("Exception Occurred",ex.getMessage(),request.getRequestURI()));

    }

}
