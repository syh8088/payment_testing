package com.payment_testing.api.payment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment_testing.api.payment.model.request.PaymentCheckOutRequest;
import com.payment_testing.api.payment.model.response.PaymentCheckOutResponse;
import com.payment_testing.api.payment.service.PaymentCheckOutApiService;
import com.payment_testing.domain.payment.model.response.PaymentCheckOutOutPut;
import com.payment_testing.domain.payment.service.PaymentCheckOutQueryService;
import com.payment_testing.domain.payment.validator.PaymentValidator;
import com.payment_testing.domain.product.service.ProductQueryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {
        PaymentCheckoutController.class
})
class PaymentCheckoutControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    protected PaymentCheckOutApiService paymentCheckOutApiService;

    @MockBean
    protected PaymentCheckOutQueryService paymentCheckOutQueryService;

    @MockBean
    protected ProductQueryService productQueryService;

    @MockBean
    protected PaymentValidator paymentValidator;

//    @Test
    @DisplayName("결제 CheckOut 진행 합니다.")
    void checkout() throws Exception {

        // given
        PaymentCheckOutRequest request = PaymentCheckOutRequest.builder()
                .productNoList(Arrays.asList(1L, 2L, 3L))
                .build();

        PaymentCheckOutOutPut paymentCheckOutOutPut = PaymentCheckOutOutPut.of(BigDecimal.TEN, "orderId", "orderName");
        PaymentCheckOutResponse paymentCheckOutResponse = PaymentCheckOutResponse.of(paymentCheckOutOutPut);

        when(paymentCheckOutApiService.paymentCheckOut(request))
                .thenReturn(paymentCheckOutResponse);

        when(paymentCheckOutQueryService.paymentCheckOut(any(String.class), any(List.class)))
                .thenReturn(PaymentCheckOutOutPut.of(BigDecimal.TEN, "orderId", "orderName"));

        // when // then
        mockMvc.perform(
                        get("")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.message").value("OK"))
                .andExpect(jsonPath("$.data").isArray());
        ;
    }
}