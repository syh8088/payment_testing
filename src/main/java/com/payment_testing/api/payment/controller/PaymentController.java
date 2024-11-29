package com.payment_testing.api.payment.controller;

import com.payment_testing.api.payment.model.request.PaymentConfirmRequest;
import com.payment_testing.api.payment.service.PaymentApiService;
import com.payment_testing.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentApiService paymentApiService;

    @GetMapping
    public ApiResponse<?> selectPayments() {

        paymentApiService.selectPayments();

        return null;
//        return ApiResponse.ok(orderService.createOrder(request.toServiceRequest(), registeredDateTime));
    }
}
