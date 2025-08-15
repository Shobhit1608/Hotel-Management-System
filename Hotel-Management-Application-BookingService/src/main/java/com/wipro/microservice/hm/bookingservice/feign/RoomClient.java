package com.wipro.microservice.hm.bookingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.microservice.hm.roomservice.entities.Room;


@FeignClient(name = "HOTEL-MANAGEMENT-APPLICATION-ROOMSERVICE", path = "/api/v1/rooms")
public interface RoomClient {

	@GetMapping("/roomById/{roomId}")
	public Room getRoomById(@PathVariable Long roomId);
    
}
