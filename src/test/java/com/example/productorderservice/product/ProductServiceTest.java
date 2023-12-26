package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    @Test
    void 상품등록(){
        final AddProductRequest request= new AddProductRequest(name, price, discountPolicy);
        productService.addProduct(request);
    }
}
