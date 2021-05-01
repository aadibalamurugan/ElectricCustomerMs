package com.prod.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.prod.app.controller","com.prod.app.dao","com.prod.app.entity","com.prod.app.service","com.prod.app.util","com.prod.app.repository"  })
//@EnableEurekaClient
//@EnableConfigServer
@EnableDiscoveryClient
@EnableFeignClients("com.prod") 
public class ElectricCustomerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricCustomerMsApplication.class, args);
	}

}
