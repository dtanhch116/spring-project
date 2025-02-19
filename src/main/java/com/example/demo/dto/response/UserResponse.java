package com.example.demo.dto.response;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String userId;

    private String username;
    private String password;
    private String email;
    private String phone;
    private LocalDate birthday;
}
