package com.example.jewelry.mapper;

import com.example.jewelry.dto.request.UserCreationRequest;
import com.example.jewelry.dto.request.UserUpdateRequest;
import com.example.jewelry.dto.response.UserResponse;
import com.example.jewelry.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
