package com.test.bridgeapi.infrastructure.services.impl;

import com.test.bridgeapi.infrastructure.proxies.SimilarProductProxy;
import com.test.bridgeapi.domain.Product;
import com.test.bridgeapi.infrastructure.services.IProductService;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private SimilarProductProxy productProxy;
    private Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public List<Product> productsBySimilarIds(String productId) {
        List<Product> similarProducList = new ArrayList<>();

        try {
            similarProducList = productProxy.getSimilarProductsByIds(productId)
                    .stream()
                    .map(productProxy::getProductById)
                    .collect(Collectors.toList());
        } catch( FeignException ex) {
            log.error("there was an error = {} ", ex);
        }

        return similarProducList;
    }
}
