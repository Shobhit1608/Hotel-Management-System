package com.wipro.microservice.hm.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HotelManagementApplicationNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementApplicationNotificationServiceApplication.class, args);
	}

}
