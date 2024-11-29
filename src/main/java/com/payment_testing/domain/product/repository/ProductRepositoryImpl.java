package com.payment_testing.domain.product.repository;

import com.payment_testing.domain.payment.model.entity.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

	QProduct qProduct = QProduct.product;

	private final JPAQueryFactory queryFactory;

	public ProductRepositoryImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

}



