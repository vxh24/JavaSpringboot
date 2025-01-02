package com.example.jewelry.service;

import com.example.jewelry.dto.request.UserCreationRequest;
import com.example.jewelry.dto.request.UserUpdateRequest;
import com.example.jewelry.entity.User;
import com.example.jewelry.exception.AppException;
import com.example.jewelry.exception.ErrorCode;
import com.example.jewelry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(UserCreationRequest request){
        User user =new User();
        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setDob(request.getDob());
        return userRepository.save(user);

    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public  User getUser(String id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not exits"));
    }
    public  User updateUser(String userId, UserUpdateRequest request){
        User user = getUser(userId);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setDob(request.getDob());
        return userRepository.save(user);

    }
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
