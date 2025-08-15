package com.wipro.microservice.hm.roomservice.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.microservice.hm.roomservice.entities.Room;
import com.wipro.microservice.hm.roomservice.services.RoomService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

	private final RoomService roomService;
	
	 @PostMapping("/addRoom")
	 public Room addRoom(@Valid @RequestBody Room room) {
	        return roomService.addRoom(room);
	    }
	 
		@GetMapping("/roomsByHotel/{hotelId}")
		public Page<Room> getRoomsByHotel(@PathVariable Long hotelId, Pageable pageable) {
			return roomService.getRoomsByHotel(hotelId, pageable);
		}
		@GetMapping("/roomById/{roomId}")
		public Room getRoomById(@PathVariable Long roomId) {
		    return roomService.getRoomById(roomId); // You'll need to implement this in the service
		}
		
		@GetMapping("/roomsByPrice/{price}")
		public Page<Room> getRoomsByPrice(@PathVariable double price, Pageable pageable) {
			return roomService.getRoomsByPrice(price, pageable);
		}
		
		@GetMapping("/roomsAvailability/{status}")
		public Page<Room> getRoomsByAvailability(@PathVariable boolean status, Pageable pageable) {
			return roomService.getRoomsByAvailability(status, pageable);
		}
		@PatchMapping("/roomAvailability/{roomId}")
		public void updateRoomAvailability(@PathVariable Long roomId, @RequestParam boolean available) {
		    roomService.updateAvailability(roomId, available); 
		}
}
