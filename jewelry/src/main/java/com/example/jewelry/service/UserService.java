package com.example.jewelry.service;

import com.example.jewelry.dto.request.UserCreationRequest;
import com.example.jewelry.dto.request.UserUpdateRequest;
import com.example.jewelry.dto.response.UserResponse;
import com.example.jewelry.entity.User;
import com.example.jewelry.enums.Role;
import com.example.jewelry.exception.AppException;
import com.example.jewelry.exception.ErrorCode;
import com.example.jewelry.mapper.UserMapper;
import com.example.jewelry.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true )
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    public User createUser(UserCreationRequest request){
        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user =userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);
        return userRepository.save(user);

    }
    public List<UserResponse> getUsers(){
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }
    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not exits")));
    }
    public  UserResponse updateUser(String userId, UserUpdateRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not exits"));

        userMapper.updateUser(user,request);
        return userMapper.toUserResponse(userRepository.save(user));

    }
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
