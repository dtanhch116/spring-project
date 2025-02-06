package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User createUser(UserDTO request);
}
