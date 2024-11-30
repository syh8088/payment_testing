package com.payment_testing.api.payment.service;

import com.payment_testing.api.payment.model.request.PaymentCheckOutRequest;
import com.payment_testing.api.payment.model.response.PaymentCheckOutResponse;
import com.payment_testing.common.IdempotencyCreator;
import com.payment_testing.domain.payment.model.entity.Product;
import com.payment_testing.domain.payment.model.response.ProductOutPut;
import com.payment_testing.domain.product.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class PaymentCheckOutApiServiceTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PaymentCheckOutApiService paymentCheckOutApiService;

    @Test
    @DisplayName("상품 주문 하기 위한 CheckOut 기능을 실행 합니다.")
    void paymentCheckOut() {

        // given
        Product product1 = this.createProduct("AAA", "상품A", BigDecimal.valueOf(1000));
        Product product2 = this.createProduct("BBB", "상품B", BigDecimal.valueOf(2000));
        Product product3 = this.createProduct("CCC", "상품C", BigDecimal.valueOf(3000));

        List<Product> productList = productRepository.saveAll(List.of(product1, product2, product3));
        List<ProductOutPut> productOutPutList = ProductOutPut.of(productList);
        List<Long> productNoList = productOutPutList.stream()
                .map(ProductOutPut::getNo)
                .toList();

        PaymentCheckOutRequest paymentCheckOutRequest = PaymentCheckOutRequest.of(productNoList);

        // when
        PaymentCheckOutResponse paymentCheckOutResponse = paymentCheckOutApiService.paymentCheckOut(paymentCheckOutRequest);

        // then
        assertThat(paymentCheckOutResponse.getOrderId()).isNotNull();

        String idempotency = IdempotencyCreator.create(paymentCheckOutRequest);
        assertThat(paymentCheckOutResponse.getOrderId()).isEqualTo(idempotency);

        assertThat(paymentCheckOutResponse.getAmount()).isEqualByComparingTo(BigDecimal.valueOf(6000));
    }

    private Product createProduct(String productId, String name, BigDecimal price) {

        return Product.of(productId, name, price);
    }
}