package com.wipro.microservice.hm.bookingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "HOTEL-MANAGEMENT-APPLICATION-USERSERVICE", path = "/api/v1/users")
public interface UserClient {
    @GetMapping("/exists")
    boolean existsById(@RequestParam Long userId);
}