package com.wipro.microservice.hm.roomservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HotelManagemntApplicationRoomServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagemntApplicationRoomServiceApplication.class, args);
	}

}
