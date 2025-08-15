package com.wipro.microservice.hm.roomservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.microservice.hm.roomservice.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

	Page<Room> findByHotelId(Long hotelId, Pageable pageable);

	Page<Room> findByPricePerNight(double price, Pageable pageable);

	Page<Room> findByAvailable(boolean status, Pageable pageable);

}