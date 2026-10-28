package com.jsp.ecommerce.service.imp;

import com.jsp.ecommerce.dto.UserLoginReq;
import com.jsp.ecommerce.dto.UserResponse;
import com.jsp.ecommerce.dto.UserSignUpReq;
import com.jsp.ecommerce.entity.User;
import com.jsp.ecommerce.exception.UserAlreadyExists;
import com.jsp.ecommerce.exception.UserNotFound;
import com.jsp.ecommerce.exception.UserPasswordInvalid;
import com.jsp.ecommerce.repository.UserRepository;
import com.jsp.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp1 implements UserService {
        private final UserRepository userRepo;
        private final ObjectMapper objectMapper;

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(()-> new UserNotFound("User with id "+id+" not found"));
    }

    public UserResponse CreateUser(UserSignUpReq userSignUpReq){

        if(userRepo.existsByEmail(userSignUpReq.getEmail())){
            throw new UserAlreadyExists("User with email "+userSignUpReq.getEmail()+" already exists");
        }

        User user =objectMapper.convertValue(userSignUpReq,User.class);

        user = userRepo.save(user);

        return objectMapper.convertValue(user,UserResponse.class);
    }

    public UserResponse login(UserLoginReq userLoginReq){
        User user = userRepo.findByEmail(userLoginReq.getEmail())
                    .orElseThrow(()-> new UserNotFound("User with email "+userLoginReq.getEmail()+" not found"));

        if(!user.getPassword().equals(userLoginReq.getPassword())) {throw new UserPasswordInvalid("invalid Password");}

        return objectMapper.convertValue(user,UserResponse.class);
    }
    public List<UserResponse> fetchAll(){
        List<UserResponse> userRes =new ArrayList<UserResponse>();
        List<User> users = userRepo.findAll();
        users.stream().forEach(u->userRes.add(objectMapper.convertValue(u,UserResponse.class)));
        return userRes;
    }

}
