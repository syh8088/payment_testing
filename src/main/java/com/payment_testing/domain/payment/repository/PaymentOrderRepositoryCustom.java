package com.payment_testing.domain.payment.repository;

import com.payment_testing.api.payment.model.response.PaymentOrderOutPut;
import com.payment_testing.domain.payment.model.response.PaymentOrderStatusOutPut;

import java.util.List;

public interface PaymentOrderRepositoryCustom {

    List<PaymentOrderStatusOutPut> selectPaymentOrderStatusListByOrderId(String orderId);

    List<PaymentOrderOutPut> selectPaymentOrderListWithProductByOrderIdList(List<String> orderIdList);
}
