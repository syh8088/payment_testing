package com.payment_testing.domain.payment.model.response.toss;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EasyPay {
    private String provider;
    private int amount;
    private int discountAmount;
}