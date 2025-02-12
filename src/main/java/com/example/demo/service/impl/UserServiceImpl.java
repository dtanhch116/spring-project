package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.exception.AppException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found")));
    }

    public UserResponse createUser(UserDTO request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }

        User user = userMapper.toUser(request);



        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse updateUser(String id, UserDTO request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
//        user.setBirthday(request.getBirthday());
//        user.setPassword(request.getPassword());
//        user.setEmail(request.getEmail());
//        user.setPhone(request.getPhone());
//        user.setUsername(request.getUsername());
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

     public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
