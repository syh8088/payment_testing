package com.payment_testing.api.payment.model.response;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.payment_testing.api.payment.model.response.QPaymentEventOutPut is a Querydsl Projection type for PaymentEventOutPut
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPaymentEventOutPut extends ConstructorExpression<PaymentEventOutPut> {

    private static final long serialVersionUID = 1489020573L;

    public QPaymentEventOutPut(com.querydsl.core.types.Expression<Long> paymentEventNo, com.querydsl.core.types.Expression<String> paymentKey, com.querydsl.core.types.Expression<String> orderId, com.querydsl.core.types.Expression<String> orderName, com.querydsl.core.types.Expression<com.payment_testing.domain.payment.enums.PaymentEventMethod> method, com.querydsl.core.types.Expression<com.payment_testing.domain.payment.enums.PaymentEventType> type, com.querydsl.core.types.Expression<java.time.LocalDateTime> approvedDateTime, com.querydsl.core.types.Expression<Boolean> isPaymentDone) {
        super(PaymentEventOutPut.class, new Class<?>[]{long.class, String.class, String.class, String.class, com.payment_testing.domain.payment.enums.PaymentEventMethod.class, com.payment_testing.domain.payment.enums.PaymentEventType.class, java.time.LocalDateTime.class, boolean.class}, paymentEventNo, paymentKey, orderId, orderName, method, type, approvedDateTime, isPaymentDone);
    }

}

