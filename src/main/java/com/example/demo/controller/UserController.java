package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/list-user")
    private List<User> getUsers() {
        return userService.getUsers();
    }


    @PostMapping("/create-user")
    private ApiResponse<User> createUser(@RequestBody @Valid UserDTO request) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(200);
        apiResponse.setData(userService.createUser(request));
       return apiResponse;
    }

    @PostMapping("/update-user/{userId}")
    private UserResponse updateUser(@PathVariable String userId, @RequestBody UserDTO request) {
        return userService.updateUser(userId, request);
    }

    @GetMapping("/user/{userId}")
    private UserResponse getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping("/delete/{userId}")
    private void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
