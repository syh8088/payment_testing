package com.payment_testing.error.exception;


import com.payment_testing.config.handler.CustomMessageHandler;
import com.payment_testing.error.errorCode.ErrorCode;

public class PaymentException extends RuntimeException {

    private ErrorCode errorCode;
    private String pspErrorCode;
    private String message;
    private int httpStatus;
    private String pspRawData;

    public PaymentException(String message) {
        super(message);
    }

    public PaymentException(ErrorCode errorCode) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
        this.message = CustomMessageHandler.getMessage(errorCode.getCode());
        this.httpStatus = errorCode.getHttpStatus();
    }

    public PaymentException(ErrorCode errorCode, Object[] errorMessage) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
        this.message = CustomMessageHandler.getMessage(errorCode.getCodePath(), errorMessage);
        this.httpStatus = errorCode.getHttpStatus();
    }

    public PaymentException(ErrorCode errorCode, String pspErrorCode, Object[] errorMessage, String pspRawData) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
        this.pspErrorCode = pspErrorCode;
        this.message = CustomMessageHandler.getMessage(errorCode.getCodePath(), errorMessage);
        this.httpStatus = errorCode.getHttpStatus();
        this.pspRawData = pspRawData;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public static boolean supports(Class<?> clazz) {
        return PaymentException.class.isAssignableFrom(clazz);
    }

    public String getPspRawData() {
        return pspRawData;
    }

    public String getPspErrorCode() {
        return pspErrorCode;
    }

}