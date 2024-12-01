package com.payment_testing.api.payment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment_testing.api.payment.model.response.PaymentEventOutPut;
import com.payment_testing.api.payment.service.PaymentApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {
        PaymentController.class
})
class PaymentControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    private PaymentApiService paymentApiService;

    @Test
    @DisplayName("결제 내역 목록 조회 진행 합니다.")
    void selectPayments() throws Exception {

        // given
        List<PaymentEventOutPut> result = List.of();
        when(paymentApiService.selectPayments()).thenReturn(result);

        // when // then
        mockMvc.perform(
                        get("/api/payments")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.message").value("OK"));
    }

}