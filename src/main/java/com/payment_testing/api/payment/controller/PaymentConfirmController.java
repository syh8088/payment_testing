package com.payment_testing.api.payment.controller;

import com.payment_testing.api.payment.model.request.PaymentConfirmRequest;
import com.payment_testing.api.payment.service.PaymentConfirmApiService;
import com.payment_testing.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentConfirmController {

    private final PaymentConfirmApiService paymentConfirmApiService;

    @PostMapping("confirm")
    public ApiResponse<?> paymentConfirm(@RequestBody PaymentConfirmRequest request) {
        LocalDateTime registeredDateTime = LocalDateTime.now();

        paymentConfirmApiService.paymentConfirm(request);

        return null;
//        return ApiResponse.ok(orderService.createOrder(request.toServiceRequest(), registeredDateTime));
    }

}
