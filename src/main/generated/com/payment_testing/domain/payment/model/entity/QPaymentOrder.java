package com.payment_testing.domain.payment.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaymentOrder is a Querydsl query type for PaymentOrder
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentOrder extends EntityPathBase<PaymentOrder> {

    private static final long serialVersionUID = 1503546720L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaymentOrder paymentOrder = new QPaymentOrder("paymentOrder");

    public final com.payment_testing.common.QCommonEntity _super = new com.payment_testing.common.QCommonEntity(this);

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDateTime = _super.createdDateTime;

    public final NumberPath<Integer> failedCount = createNumber("failedCount", Integer.class);

    public final NumberPath<Long> no = createNumber("no", Long.class);

    public final StringPath orderId = createString("orderId");

    public final QPaymentEvent paymentEvent;

    public final QProduct product;

    public final EnumPath<com.payment_testing.domain.payment.enums.PaymentOrderStatus> status = createEnum("status", com.payment_testing.domain.payment.enums.PaymentOrderStatus.class);

    public final NumberPath<Integer> threshold = createNumber("threshold", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDateTime = _super.updatedDateTime;

    public QPaymentOrder(String variable) {
        this(PaymentOrder.class, forVariable(variable), INITS);
    }

    public QPaymentOrder(Path<? extends PaymentOrder> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPaymentOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPaymentOrder(PathMetadata metadata, PathInits inits) {
        this(PaymentOrder.class, metadata, inits);
    }

    public QPaymentOrder(Class<? extends PaymentOrder> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.paymentEvent = inits.isInitialized("paymentEvent") ? new QPaymentEvent(forProperty("paymentEvent")) : null;
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product")) : null;
    }

}

