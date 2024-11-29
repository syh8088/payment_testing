package com.payment_testing.domain.payment.service;

import com.payment_testing.domain.payment.model.entity.Product;
import com.payment_testing.domain.payment.model.response.ProductOutPut;
import com.payment_testing.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductQueryService {

    private final ProductRepository productRepository;

    public List<ProductOutPut> selectProductListByProductNoList(List<Long> productNoList) {
        List<Product> products = productRepository.selectProductListByProductNoList(productNoList);
        return products.stream()
                .map(product -> ProductOutPut.of(product.getNo(), product.getProductId(), product.getName(), product.getPrice()))
                .toList();
    }
}
