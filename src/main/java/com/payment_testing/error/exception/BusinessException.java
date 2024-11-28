package com.payment_testing.error.exception;

import com.payment_testing.config.handler.CustomMessageHandler;
import com.payment_testing.error.errorCode.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String message;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
        this.message = CustomMessageHandler.getMessage(errorCode.getCode());
    }

    public BusinessException(ErrorCode errorCode, Object[] errorMessages) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
        this.message = CustomMessageHandler.getMessage(errorCode.getCode(), errorMessages);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode.getCode();
    }
}
