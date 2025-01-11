package com.example.jewelry.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001,"User existed"),
    USER_NOT_EXISTED(1004,"User not existed"),
    USERNAME_INVALID(1002,"Username must be at least 3 characters"),
    PASSWORD_INVALID(1003,"Password must be at least 6 characters"),
    INVALID_KEY(9999,"Invalid key"),
    UNAUTHENTICATED(1005,"Unauthenticated"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;
    private final String message;

}
