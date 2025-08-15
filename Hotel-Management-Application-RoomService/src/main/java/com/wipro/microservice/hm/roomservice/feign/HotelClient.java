package com.wipro.microservice.hm.roomservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.microservice.hm.roomservice.entities.Room;

@FeignClient(name = "HOTEL-MANAGEMENT-APPLICATION-HOTELSERVICE", path = "/api/v1/hotels")
public interface HotelClient {

	@GetMapping("/roomsByHotel/{hotelId}")
	public Page<Room> getRoomsByHotel(@PathVariable Long hotelId, Pageable pageable);

	@GetMapping("/exists")
    boolean existsById(@RequestParam("hotelId") Long hotelId);
}