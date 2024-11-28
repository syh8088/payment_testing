package com.payment_testing.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResponse<T> {

    private final String code;
    private final HttpStatus status;
    private final String message;
    private final T data;

    private ApiResponse(String code, HttpStatus status, String message, T data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> of(String code, HttpStatus httpStatus, String message) {
        return new ApiResponse<>(code, httpStatus, message, null);
    }

}