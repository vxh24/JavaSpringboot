package com.example.jewelry.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001,"User existed", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1004,"User not existed",HttpStatus.NOT_FOUND),
    USERNAME_INVALID(1002,"Username must be at least {min} characters",HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1003,"Password must be at least {min} characters",HttpStatus.BAD_REQUEST),
    INVALID_KEY(9999,"Invalid key",HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHENTICATED(1005,"Unauthenticated",HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1006,"You do not have permission",HttpStatus.FORBIDDEN),
    INVALID_DOB(1007,"Your age must be at least {min}",HttpStatus.BAD_REQUEST)
    ;

    ErrorCode(int code, String message,HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;

    private final String message;
    private final HttpStatusCode statusCode;
}
