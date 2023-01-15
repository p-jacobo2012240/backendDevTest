package com.test.bridgeapi.infrastructure.services;

import com.test.bridgeapi.domain.Product;

import java.util.List;

public interface IProductService {

    public List<Product> productsBySimilarIds(String productId);
}
