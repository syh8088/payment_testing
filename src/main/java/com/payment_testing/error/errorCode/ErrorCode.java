package com.payment_testing.error.errorCode;

public interface ErrorCode {
    String getCode();
    String getCodePath();
    int getHttpStatus();
}
