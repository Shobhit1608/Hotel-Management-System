package com.wipro.microservice.hm.userservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient 
public class HotelManagemntApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagemntApplication.class, args);
	}
}