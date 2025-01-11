package com.example.jewelry.controller;

import com.example.jewelry.dto.request.ApiResponse;
import com.example.jewelry.dto.request.UserCreationRequest;
import com.example.jewelry.dto.request.UserUpdateRequest;
import com.example.jewelry.dto.response.UserResponse;
import com.example.jewelry.entity.User;
import com.example.jewelry.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> apiResponse =new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }
    @GetMapping
    List<User> getUser(){
        return userService.getUsers();
    }
    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") String userId){
        return  userService.getUser(userId);
    }
    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId,@RequestBody UserUpdateRequest request){
        return userService.updateUser(userId,request);
    }
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "user has been deleted";
    }
}
