package com.payment_testing.error.exception;

import com.payment_testing.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BusinessException.class)
    public ApiResponse<?> handleBaseException(BusinessException e) {

        return ApiResponse.of(HttpStatus.BAD_REQUEST, e.getMessage(), e.getErrorCode());
    }
}
