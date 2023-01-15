package com.test.bridgeapi.infrastructure.controllers;

import com.test.bridgeapi.domain.Product;
import com.test.bridgeapi.infrastructure.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/product/{productId}/similar")
    public ResponseEntity<List<Product>> productsBySimilarIds(@PathVariable String productId) {
        List<Product> similarProducts = productService.productsBySimilarIds(productId);
        return new ResponseEntity<>(similarProducts, HttpStatus.OK);
    }
}
