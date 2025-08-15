package com.wipro.microservice.hm.bookingservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-MANAGEMENT-APPLICATION-NOTIFICATIONSERVICE", path ="/api/v1/notifications")
public interface NotificationClient {

	 @PostMapping("/booking/{bookingId}")
	  String sendBookingConfirmation(@PathVariable Long bookingId);
}
