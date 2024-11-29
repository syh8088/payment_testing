package com.payment_testing.domain.payment.model.entity;

import com.payment_testing.common.CommonEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "products")
public class Product extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private Long no;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Builder
    private Product(Long no, String productId, String name, BigDecimal price) {
        this.no = no;
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public static Product of(String productId, String name, BigDecimal price) {
        return Product.builder()
                .productId(productId)
                .name(name)
                .price(price)
                .build();
    }

    public static Product of(long productNo) {
        return Product.builder()
                .no(productNo)
                .build();
    }

    public static List<Product> of(List<Long> productNoList) {
        return productNoList.stream()
                .map(Product::of)
                .collect(Collectors.toList());
    }
}
