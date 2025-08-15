package com.wipro.microservice.hm.roomservice.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.microservice.hm.roomservice.entities.Room;

import jakarta.validation.Valid;

public interface RoomService {

	Room addRoom(@Valid Room room);

	Page<Room> getRoomsByHotel(Long hotelId, Pageable pageable);

	Page<Room> getRoomsByPrice(double price, Pageable pageable);

	Page<Room> getRoomsByAvailability(boolean status, Pageable pageable);

	Room getRoomById(Long roomId);

	void updateAvailability(Long roomId, boolean available);

}
