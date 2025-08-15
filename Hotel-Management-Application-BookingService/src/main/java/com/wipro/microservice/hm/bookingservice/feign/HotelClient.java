package com.wipro.microservice.hm.bookingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "HOTEL-MANAGEMENT-APPLICATION-HOTELSERVICE", path = "/api/v1/hotels")
public interface HotelClient {
    @GetMapping("/exists")
    boolean existsById(@RequestParam Long hotelId);
}