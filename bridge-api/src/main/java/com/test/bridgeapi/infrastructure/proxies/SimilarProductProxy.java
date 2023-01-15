package com.test.bridgeapi.infrastructure.proxies;

import com.test.bridgeapi.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "${proxy.name}", url = "${proxy.url}")
public interface SimilarProductProxy {

    @GetMapping(value = "/product/{productId}")
    Product getProductById(@PathVariable String productId);

    @GetMapping(value = "/product/{productId}/similarids")
    List<String> getSimilarProductsByIds(@PathVariable String productId);
}
