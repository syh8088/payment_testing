package com.payment_testing.domain.payment.model.response;

import com.payment_testing.domain.payment.model.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
public class ProductOutPut {

    private long no;
    private String productId;
    private String name;
    private BigDecimal price;

    @Builder
    private ProductOutPut(long no, String productId, String name, BigDecimal price) {
        this.no = no;
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public static List<ProductOutPut> of(List<Product> productList) {
        return productList.stream()
                .map(data -> of(data.getNo(), data.getProductId(), data.getName(), data.getPrice()))
                .toList();
    }

    public static ProductOutPut of(long no, String productId, String name, BigDecimal price) {
        return ProductOutPut.builder()
                .no(no)
                .productId(productId)
                .name(name)
                .price(price)
                .build();
    }

    public static BigDecimal getTotalAmount(List<ProductOutPut> productList) {
        return productList
                .stream()
                .map(ProductOutPut::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static String getOrderName(List<ProductOutPut> productList) {

        if (!Objects.isNull(productList) && !productList.isEmpty()) {
            return productList.get(0).getName() + " 그외";
        }
        else {
            return productList.get(0).getName();
        }
    }
}
