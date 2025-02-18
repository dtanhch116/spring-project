package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION (9999, "Uncategorized Exception"),
    INVALID_KEY (8888, "invalid key"),
    USER_NAME_INVALID (8888, "Tối thiểu 8 kí tự"),
    EMAIL_EXISTED (1001, "email already existed"),
    USER_NOT_EXISTED (1002, "User not existed"),
    ;
    private int code;
    private String message;
}
