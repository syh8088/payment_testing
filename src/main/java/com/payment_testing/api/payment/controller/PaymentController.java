package com.payment_testing.api.payment.controller;

import com.payment_testing.api.payment.model.response.PaymentEventOutPut;
import com.payment_testing.api.payment.model.response.PaymentEventResponse;
import com.payment_testing.api.payment.model.response.PaymentEventWithOrderResponse;
import com.payment_testing.api.payment.service.PaymentApiService;
import com.payment_testing.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentApiService paymentApiService;

    @GetMapping
    public ApiResponse<PaymentEventWithOrderResponse> selectPayments() {

        List<PaymentEventOutPut> paymentEventOutPutList = paymentApiService.selectPayments();
        List<PaymentEventResponse> paymentEventResponses = PaymentEventResponse.of(paymentEventOutPutList);
        PaymentEventWithOrderResponse paymentEventWithOrderResponse = PaymentEventWithOrderResponse.of(paymentEventResponses);

        return ApiResponse.ok(paymentEventWithOrderResponse);
    }
}
