package com.wipro.microservice.hm.hotelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class HotelManagemntApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagemntApplication.class, args);
	}

}
