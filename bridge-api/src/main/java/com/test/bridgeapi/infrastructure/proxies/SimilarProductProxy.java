package com.test.bridgeapi.infrastructure.proxies;

import com.test.bridgeapi.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "${proxy.name}", url = "${proxy.url}")
public interface SimilarProductProxy {
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    Product getProductById(@PathVariable String productId);
    @RequestMapping(value = "/product/{productId}/similarids", method = RequestMethod.GET)
    List<String> getSimilarProductsByIds(@PathVariable String productId);

}
