package com.wipro.microservice.hm.hotelservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.microservice.hm.hotelservice.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

	Page<Hotel> findByLocationIgnoreCase(String location, Pageable pageable);
	Page<Hotel> findByCategoryIgnoreCase(String category, Pageable pageable);

}
