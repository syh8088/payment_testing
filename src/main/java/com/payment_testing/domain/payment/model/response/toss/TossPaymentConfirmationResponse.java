package com.payment_testing.domain.payment.model.response.toss;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TossPaymentConfirmationResponse {

    private String version;
    private String paymentKey;
    private String type;
    private String orderId;
    private String orderName;
    private String mId;
    private String currency;
    private String method;
    private int totalAmount;
    private int balanceAmount;
    private String status;
    private String requestedAt;
    private String approvedAt;
    private boolean useEscrow;
    private String lastTransactionKey;
    private int suppliedAmount;
    private int vat;
    private boolean cultureExpense;
    private int taxFreeAmount;
    private int taxExemptionAmount;
    private List<Cancel> cancels;
    private Card card;
    private VirtualAccount virtualAccount;
    private MobilePhone mobilePhone;
    private GiftCertificate giftCertificate;
    private Transfer transfer;
    private Receipt receipt;
    private Checkout checkout;
    private EasyPay easyPay;
    private String country;
    private TossFailureResponse failure;
    private CashReceipt cashReceipt;
    private List<CashReceipt> cashReceipts;
    private Discount discount;
}



