package com.test.bridgeapi.infrastructure.services.impl;

import com.test.bridgeapi.infrastructure.proxies.SimilarProductProxy;
import com.test.bridgeapi.domain.Product;
import com.test.bridgeapi.infrastructure.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private SimilarProductProxy productProxy;

    @Override
    public List<Product> productsBySimilarIds(String productId) {
        return productProxy.getSimilarProductsByIds(productId)
                .stream()
                .map(productProxy::getProductById)
                .collect(Collectors.toList());
    }
}
