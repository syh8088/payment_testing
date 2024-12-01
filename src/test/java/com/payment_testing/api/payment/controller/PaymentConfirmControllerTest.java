package com.payment_testing.api.payment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment_testing.api.payment.model.request.PaymentConfirmRequest;
import com.payment_testing.api.payment.service.PaymentConfirmApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {
        PaymentConfirmController.class
})
class PaymentConfirmControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    private PaymentConfirmApiService paymentConfirmApiService;

    @Test
    @DisplayName("결제 승인 confirm 처리를 하도록 합니다.")
    void paymentConfirm() throws Exception {

        // given
        PaymentConfirmRequest request
                = PaymentConfirmRequest.of("paymentKey", "orderId", "6000");

        // when // then
        mockMvc.perform(
                        post("/api/payments/confirm")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.code").value("204"))
                .andExpect(jsonPath("$.status").value("NO_CONTENT"))
                .andExpect(jsonPath("$.message").value("NO_CONTENT"))
                .andExpect(jsonPath("$.data").isEmpty());
        ;
    }
}