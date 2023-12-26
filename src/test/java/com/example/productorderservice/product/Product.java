package com.example.productorderservice.product;

import org.springframework.util.Assert;

class Product {
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;
    private Long id;

    public Product(final String name, final int price, final DiscountPolicy discountPolicy) {
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
        ///validation 체크
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    }

    public void assignId(final Long id) {
        this.id = id;

    }

    public Long getId() {
        return id;
    }
}
