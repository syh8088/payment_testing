package com.payment_testing.api.payment.model.response;

import com.payment_testing.domain.payment.model.response.PaymentCheckOutOutPut;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PaymentCheckOutResponse {

    private final BigDecimal amount;
    private final String orderId;
    private final String orderName;

    @Builder
    private PaymentCheckOutResponse(BigDecimal amount, String orderId, String orderName) {
        this.amount = amount;
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public static PaymentCheckOutResponse of(PaymentCheckOutOutPut paymentCheckOutOutPut) {
        return new PaymentCheckOutResponse(
                paymentCheckOutOutPut.getAmount(),
                paymentCheckOutOutPut.getOrderId(),
                paymentCheckOutOutPut.getOrderName()
        );
    }
}