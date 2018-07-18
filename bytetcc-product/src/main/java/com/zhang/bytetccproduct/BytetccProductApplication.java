package com.zhang.bytetccproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
@EnableFeignClients
public class BytetccProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(BytetccProductApplication.class, args);
	}
}
