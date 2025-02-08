package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    public User createUser(UserDTO request) {
        User user = new User();

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("email already exists");
        }

        user.setBirthday(request.getBirthday());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setUsername(request.getUsername());
//        BeanUtils.copyProperties(request, user);
        return userRepository.save(user);
    }

    public User updateUser(String id, UserDTO request) {
        User user = getUser(id);
        user.setBirthday(request.getBirthday());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setUsername(request.getUsername());
        return userRepository.save(user);
    }

     public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
