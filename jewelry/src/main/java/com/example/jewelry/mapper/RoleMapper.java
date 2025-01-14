package com.example.jewelry.mapper;

import com.example.jewelry.dto.request.RoleRequest;
import com.example.jewelry.dto.response.RoleResponse;
import com.example.jewelry.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions",ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);

}
