package com.payment_testing.api.payment.service;

import com.payment_testing.api.payment.model.request.PaymentConfirmRequest;
import com.payment_testing.domain.payment.model.request.PaymentConfirmInPut;
import com.payment_testing.domain.payment.model.response.PaymentExecutionResultOutPut;
import com.payment_testing.domain.payment.service.toss.TossPaymentExecutor;
import com.payment_testing.domain.payment.validator.PaymentValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@RequiredArgsConstructor
public class PaymentConfirmApiService {

    private final PaymentValidator paymentValidator;
    private final TossPaymentExecutor tossPaymentExecutor;
    private final PaymentStatusUpdateApiService paymentStatusUpdateApiService;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void paymentConfirm(PaymentConfirmRequest request) {

        paymentValidator.paymentTotalAmountValidation(request.getOrderId(), request.getAmount());

        PaymentConfirmInPut paymentConfirmInPut = PaymentConfirmInPut.of(request.getPaymentKey(), request.getOrderId(), request.getAmount());
        PaymentExecutionResultOutPut paymentExecutionResult = tossPaymentExecutor.paymentConfirm(paymentConfirmInPut);

        paymentStatusUpdateApiService.updatePaymentStatus(paymentExecutionResult);
    }
}
