package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO user);

    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserDTO userDTO);
}
