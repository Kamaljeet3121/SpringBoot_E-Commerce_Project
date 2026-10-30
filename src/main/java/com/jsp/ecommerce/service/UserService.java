package com.jsp.ecommerce.service;

import com.jsp.ecommerce.dto.UserLoginReq;
import com.jsp.ecommerce.dto.UserResponse;
import com.jsp.ecommerce.dto.UserSignUpReq;
import com.jsp.ecommerce.entity.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    UserResponse CreateUser(UserSignUpReq userSignUpReq);

    UserResponse loginByEmail(UserLoginReq userLoginReq);
    UserResponse loginByPhone(UserLoginReq userLoginReq);

    List<UserResponse> fetchAll();
}
