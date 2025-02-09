package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    UserResponse createUser(UserDTO request);

    UserResponse updateUser(String id, UserDTO request);

    UserResponse getUser(String id);

    void deleteUser(String id);
}
