package com.payment_testing.api.payment.service;

import com.payment_testing.api.payment.model.response.PaymentEventOutPut;
import com.payment_testing.domain.payment.service.PaymentEventQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentApiService {

    private final PaymentEventQueryService paymentEventQueryService;

    @Transactional(readOnly = true)
    public void selectPayments() {
        List<PaymentEventOutPut> paymentEventOutPutList = paymentEventQueryService.selectPayments();
    }
}
