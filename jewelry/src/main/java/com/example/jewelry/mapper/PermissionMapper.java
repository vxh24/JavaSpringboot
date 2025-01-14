package com.example.jewelry.mapper;

import com.example.jewelry.dto.request.PermissionRequest;
import com.example.jewelry.dto.request.UserCreationRequest;
import com.example.jewelry.dto.request.UserUpdateRequest;
import com.example.jewelry.dto.response.PermissionResponse;
import com.example.jewelry.dto.response.UserResponse;
import com.example.jewelry.entity.Permission;
import com.example.jewelry.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);

}
