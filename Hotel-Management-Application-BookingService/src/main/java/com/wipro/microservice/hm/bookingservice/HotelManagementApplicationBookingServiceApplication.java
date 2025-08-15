package com.wipro.microservice.hm.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HotelManagementApplicationBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementApplicationBookingServiceApplication.class, args);
	}

}
