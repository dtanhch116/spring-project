package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    @Column(name = "\"username\"")
    private String username;
    @Column(name = "\"password\"")
    private String password;
    @Column(name = "\"email\"")
    private String email;
    @Column(name = "\"phone\"")
    private String phone;
    @Column(name = "\"birthday\"")
    private LocalDate birthday;
}
