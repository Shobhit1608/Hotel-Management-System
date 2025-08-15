package com.wipro.microservice.hm.roomservice.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.microservice.hm.roomservice.feign.HotelClient;
import com.wipro.microservice.hm.roomservice.feign.UserClient;
import com.wipro.microservice.hm.hotelservice.exceptions.HotelNotFoundException;
import com.wipro.microservice.hm.roomservice.entities.Room;
import com.wipro.microservice.hm.roomservice.exceptions.RoomNotAvailableException;
import com.wipro.microservice.hm.roomservice.repositories.RoomRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
	
	private final RoomRepository roomRepository;
	private final HotelClient hotelClient;
	private final UserClient userClient;
	
	@Override
    public Room addRoom(@Valid Room room) {
		if (!hotelClient.existsById(room.getHotelId())) {
            throw new HotelNotFoundException("Hotel not found with ID: " + room.getHotelId());
            // Validate that the user booking this room exists
			
        }
		
		if (room.getId() != null && !userClient.existsById(room.getId())) {
			throw new RoomNotAvailableException("Cannot add room: User with ID " + room.getId() + " not found.");
		}
        return roomRepository.save(room);
    }

	public Page<Room> getRoomsByHotel(Long hotelId, Pageable pageable) {
        if (!hotelClient.existsById(hotelId)) {
            throw new RuntimeException("Hotel not found with ID: " + hotelId);
        }
        return roomRepository.findByHotelId(hotelId, pageable);
	}

	@Override
    public Page<Room> getRoomsByPrice(double price, Pageable pageable) {
        return roomRepository.findByPricePerNight(price, pageable);
    }

	@Override
	public Page<Room> getRoomsByAvailability(boolean status, Pageable pageable) {
	    return roomRepository.findByAvailable(status, pageable);
	}

	@Override
	public Room getRoomById(Long roomId) {
		return roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotAvailableException("Room not found with ID: " + roomId));
	}

	@Override
	public void updateAvailability(Long roomId, boolean available) {
		Room roomToUpdate = getRoomById(roomId);
		roomToUpdate.setAvailable(available);
		 roomRepository.save(roomToUpdate);
	}

}
