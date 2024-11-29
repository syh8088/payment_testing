package com.payment_testing.domain.payment.service;

import com.payment_testing.api.payment.model.response.PaymentEventOutPut;
import com.payment_testing.api.payment.model.response.PaymentOrderOutPut;
import com.payment_testing.common.IdempotencyCreator;
import com.payment_testing.domain.payment.enums.PaymentEventMethod;
import com.payment_testing.domain.payment.enums.PaymentEventType;
import com.payment_testing.domain.payment.model.entity.PaymentEvent;
import com.payment_testing.domain.payment.model.entity.Product;
import com.payment_testing.domain.payment.model.response.ProductOutPut;
import com.payment_testing.domain.payment.repository.PaymentEventRepository;
import com.payment_testing.domain.product.repository.ProductRepository;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class PaymentEventQueryServiceTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PaymentEventRepository paymentEventRepository;

    @Autowired
    private PaymentCheckOutCommendService paymentCheckOutCommendService;

    @Autowired
    private PaymentEventQueryService paymentEventQueryService;

    @Test
    @DisplayName("상품 주문 등록 후 주문 한 목록을 조회 합니다.")
    void selectAllByOrderIdIn() {

        // given
        Product product1 = this.createProduct("AAA", "상품A", BigDecimal.valueOf(1000));
        Product product2 = this.createProduct("BBB", "상품B", BigDecimal.valueOf(2000));
        Product product3 = this.createProduct("CCC", "상품C", BigDecimal.valueOf(3000));

        List<Product> productList = productRepository.saveAll(List.of(product1, product2, product3));
        List<ProductOutPut> productOutPutList = ProductOutPut.of(productList);

        String orderId1 = this.createPaymentEvent("TEST_PAYMENT1", productOutPutList);
        String orderId2 = this.createPaymentEvent("TEST_PAYMENT2", productOutPutList);

        // when
        List<PaymentEventOutPut> paymentEventOutPutList = paymentEventQueryService.selectPayments();

        // then
        assertThat(paymentEventOutPutList).hasSize(2)
                .extracting("paymentEventNo", "orderId")
                .containsExactlyInAnyOrder(
                        tuple(1L, orderId1),
                        tuple(2L, orderId2)
                );

        for (PaymentEventOutPut paymentEventOutPut : paymentEventOutPutList) {

            BigDecimal totalAmount = paymentEventOutPut.getTotalAmount();
            assertThat(totalAmount).isEqualByComparingTo(BigDecimal.valueOf(6000));

            List<PaymentOrderOutPut> paymentOrderList = paymentEventOutPut.getPaymentOrderList();

            assertThat(paymentOrderList).hasSize(3)
                    .extracting("productId", "name", "amount")
                    .usingRecursiveFieldByFieldElementComparator(
                            RecursiveComparisonConfiguration.builder()
                                    .withComparatorForType(BigDecimal::compareTo, BigDecimal.class).build()
                    )
                    .containsExactlyInAnyOrder(
                            tuple("AAA", "상품A", BigDecimal.valueOf(1000)),
                            tuple("BBB", "상품B", BigDecimal.valueOf(2000)),
                            tuple("CCC", "상품C", BigDecimal.valueOf(3000))
                    );
        }
    }


    private String createPaymentEvent(String idempotencyKey, List<ProductOutPut> productOutPutList) {

        String orderId = IdempotencyCreator.create(idempotencyKey);
        PaymentEvent paymentEvent = PaymentEvent.of(
                IdempotencyCreator.create(idempotencyKey),
                PaymentEventMethod.CARD,
                PaymentEventType.NORMAL,
                productOutPutList
        );

        paymentCheckOutCommendService.insertPaymentCheckOut(paymentEvent);

        return orderId;
    }

    private Product createProduct(String productId, String name, BigDecimal price) {

        return Product.of(productId, name, price);
    }
}