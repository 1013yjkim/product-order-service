package com.example.productorderservice.product;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductApiTest extends ApiTest{
    @Autowired
    private ProductService productService;

    @Test
    void 상품등록(){
        final AddProductRequest request = 상품등록요청_생성();

        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
        //API 요청
         assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price=1000;
        final DiscountPolicy discountPolicy=DiscountPolicy.NONE;
        return new AddProductRequest(name, price, discountPolicy);
    }


}
