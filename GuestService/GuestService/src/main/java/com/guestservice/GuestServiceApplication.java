package com.guestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients(basePackages="com.guestservice.feignclient")
@EnableSwagger2
public class GuestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestServiceApplication.class, args);
	}

}
