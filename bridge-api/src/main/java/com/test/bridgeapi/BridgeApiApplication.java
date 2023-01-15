package com.test.bridgeapi;

import com.test.bridgeapi.infrastructure.proxies.SimilarProductProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients(clients = { SimilarProductProxy.class })
public class BridgeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BridgeApiApplication.class, args);
	}

}
