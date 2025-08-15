package com.wipro.microservice.hm.bookingservice.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.wipro.microservice.hm.bookingservice.entities.Booking;
import com.wipro.microservice.hm.bookingservice.entities.BookingRequest;
import com.wipro.microservice.hm.bookingservice.services.BookingServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingServices bookingServices;

    @PostMapping("/createBooking")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@Valid @RequestBody BookingRequest bookingRequest) {
        return bookingServices.createBooking(bookingRequest);
    }

    @GetMapping("/getBookingById/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingServices.getBookingById(id);
    }
}
