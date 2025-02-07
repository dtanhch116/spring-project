package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list-user")
    private List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/create-user")
    private User createUser(@RequestBody UserDTO request) {
        return userService.createUser(request);
    }

    @PostMapping("/update-user/{userId}")
    private User updateUser(@PathVariable String userId, @RequestBody UserDTO request) {
        return userService.updateUser(userId, request);
    }

    @GetMapping("/user/{userId}")
    private User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping("/delete/{userId}")
    private void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
