package com.payment_testing.api.payment.service;

import com.payment_testing.api.payment.model.request.PaymentCheckOutRequest;
import com.payment_testing.api.payment.model.response.PaymentCheckOutResponse;
import com.payment_testing.domain.payment.model.request.PaymentCheckOutInPut;
import com.payment_testing.domain.payment.model.response.PaymentCheckOutOutPut;
import com.payment_testing.domain.payment.model.response.ProductOutPut;
import com.payment_testing.domain.payment.service.PaymentCheckOutQueryService;
import com.payment_testing.domain.payment.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentCheckOutApiService {

    private final PaymentCheckOutQueryService paymentCheckOutQueryService;
    private final ProductQueryService productQueryService;

    @Transactional
    public PaymentCheckOutResponse paymentCheckOut(PaymentCheckOutRequest request) {

        List<ProductOutPut> productList
                = productQueryService.selectProductListByProductNoList(request.getProductNoList());

        PaymentCheckOutOutPut paymentCheckOutOutPut = paymentCheckOutQueryService.paymentCheckOut(
                PaymentCheckOutInPut.of(request.getProductNoList()),
                productList
        );

        return PaymentCheckOutResponse.of(paymentCheckOutOutPut);
    }
}
