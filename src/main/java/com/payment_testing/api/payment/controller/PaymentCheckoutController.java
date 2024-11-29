package com.payment_testing.api.payment.controller;

import com.payment_testing.api.payment.model.request.PaymentCheckOutRequest;
import com.payment_testing.api.payment.model.response.PaymentCheckOutResponse;
import com.payment_testing.api.payment.service.PaymentCheckOutApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PaymentCheckoutController {

	private final PaymentCheckOutApiService paymentCheckOutApiService;

	@GetMapping
	public String checkoutPage(PaymentCheckOutRequest request, Model model) {

		PaymentCheckOutResponse paymentCheckOut = paymentCheckOutApiService.paymentCheckOut(request);

		model.addAttribute("orderId", paymentCheckOut.getOrderId());
		model.addAttribute("amount", paymentCheckOut.getAmount());
		model.addAttribute("orderName", paymentCheckOut.getOrderName());

		return "checkout";
	}
}