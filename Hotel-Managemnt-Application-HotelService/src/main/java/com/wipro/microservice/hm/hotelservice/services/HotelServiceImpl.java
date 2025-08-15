package com.wipro.microservice.hm.hotelservice.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.microservice.hm.hotelservice.entities.Hotel;
import com.wipro.microservice.hm.hotelservice.exceptions.HotelNotFoundException;
import com.wipro.microservice.hm.hotelservice.repositories.HotelRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

	private final HotelRepository hotelRepository;
	
	@Override
	public Hotel addHotel(@Valid Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public Long getNumberOfHotels() {
		return hotelRepository.count();
	}
 
	@Override
	public Hotel getHotelById(Long id) {
		return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found with ID: " + id));
	}

	@Override
	public Page<Hotel> getHotelsByLocation(String location, Pageable pageable) {
		return hotelRepository.findByLocationIgnoreCase(location, pageable);
	}

	@Override
	public Page<Hotel> getHotelsByCategory(String category, Pageable pageable) {
		return hotelRepository.findByCategoryIgnoreCase(category, pageable);
	}

	@Override
    public boolean existsById(Long id) {
        return hotelRepository.existsById(id);
    }
	
	
}
