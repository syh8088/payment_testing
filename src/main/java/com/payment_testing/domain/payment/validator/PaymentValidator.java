package com.payment_testing.domain.payment.validator;

import com.payment_testing.domain.product.model.response.ProductOutPut;
import com.payment_testing.error.errorCode.PaymentErrorCode;
import com.payment_testing.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentValidator {

    public void isExistProduct(List<ProductOutPut> productList) {

        if (Objects.isNull(productList) || productList.isEmpty()) {
            throw new BusinessException(PaymentErrorCode.NOT_EXIST_PRODUCT);
        }
    }


}
