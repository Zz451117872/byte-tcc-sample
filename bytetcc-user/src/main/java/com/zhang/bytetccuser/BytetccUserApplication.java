package com.zhang.bytetccuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

//@ImportResource({ "classpath:bytetcc-supports-springcloud.xml" })
@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
@EnableFeignClients
public class BytetccUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BytetccUserApplication.class, args);
	}
}
