package com.wipro.microservice.hm.notificationservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.microservice.hm.notificationservice.entities.Booking;

@FeignClient(
    name = "HOTEL-MANAGEMENT-APPLICATION-BOOKINGSERVICE", 
    path = "/api/v1/bookings"
)
public interface BookingClient {
    
    @GetMapping("/getBookingById/{id}")
    Booking getBookingById(@PathVariable Long id);
}
