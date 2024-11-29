package com.payment_testing.domain.payment.repository;

import com.payment_testing.api.payment.model.response.PaymentEventOutPut;

import java.util.List;

public interface PaymentEventRepositoryCustom {

    List<PaymentEventOutPut> selectPaymentEventList();

}
