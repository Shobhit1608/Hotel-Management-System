package com.wipro.microservice.hm.hotelservice.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.microservice.hm.hotelservice.entities.Hotel;

import jakarta.validation.Valid;

public interface HotelService {

	Hotel addHotel(@Valid Hotel hotel);

	Long getNumberOfHotels();

	Hotel getHotelById(Long id);

	Page<Hotel> getHotelsByLocation(String location, Pageable pageable);

	Page<Hotel> getHotelsByCategory(String category, Pageable pageable);

	boolean existsById(Long hotelId);

}
