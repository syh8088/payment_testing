package com.payment_testing.domain.payment.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -1481552521L;

    public static final QProduct product = new QProduct("product");

    public final com.payment_testing.common.QCommonEntity _super = new com.payment_testing.common.QCommonEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDateTime = _super.createdDateTime;

    public final StringPath name = createString("name");

    public final NumberPath<Long> no = createNumber("no", Long.class);

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final StringPath productId = createString("productId");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDateTime = _super.updatedDateTime;

    public QProduct(String variable) {
        super(Product.class, forVariable(variable));
    }

    public QProduct(Path<? extends Product> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProduct(PathMetadata metadata) {
        super(Product.class, metadata);
    }

}

