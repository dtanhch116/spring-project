package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class UserDTO {
    @JsonProperty("Username")
    private String Username;

    @JsonProperty("Password")
    private String Password;

    @JsonProperty("Email")
    private String Email;

    @JsonProperty("Phone")
    private String Phone;

    @JsonProperty("Birthday")
    private LocalDate Birthday;
}
