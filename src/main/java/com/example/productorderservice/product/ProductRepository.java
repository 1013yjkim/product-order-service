package com.example.productorderservice.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


interface ProductRepository extends JpaRepository<Product, Long> {
}
