package com.jsp.ecommerce.controller;

import com.jsp.ecommerce.dto.UserLoginReq;
import com.jsp.ecommerce.dto.UserResponse;
import com.jsp.ecommerce.dto.UserSignUpReq;
import com.jsp.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Auth")
public class UserController {
    private final UserService userService;
    private final ObjectMapper objectMapper;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserSignUpReq user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.CreateUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> signIn(@RequestBody @Valid UserLoginReq userLoginReq){
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(userLoginReq));
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<UserResponse>> fetchAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.fetchAll());
    }

}
