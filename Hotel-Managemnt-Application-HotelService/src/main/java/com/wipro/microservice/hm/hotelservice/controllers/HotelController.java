package com.wipro.microservice.hm.hotelservice.controllers;



import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.wipro.microservice.hm.hotelservice.entities.Hotel;
import com.wipro.microservice.hm.hotelservice.services.HotelService;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelController {	

    private final HotelService hotelService;

    @PostMapping("/addHotel")
    public Hotel addHotel(@Valid @RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @GetMapping("/NumberOfHotels")
    public Long getNumberOfHotels() {
        return hotelService.getNumberOfHotels();
    }
    
    @GetMapping("/HotelById/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping("/HotelsByLocation/{location}")
    public Page<Hotel> getHotelsByLocation(@PathVariable String location, Pageable pageable) {
        return hotelService.getHotelsByLocation(location, pageable);
    }

    @GetMapping("/HotelsByCategory/{category}")
    public Page<Hotel> getHotelsByCategory(@PathVariable String category, Pageable pageable) {
        return hotelService.getHotelsByCategory(category, pageable);
    }
    
    @GetMapping("/exists")
    public boolean hotelExists(@RequestParam Long hotelId) {
        return hotelService.existsById(hotelId);
    }

   
}

