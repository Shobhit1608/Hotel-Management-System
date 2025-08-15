package com.wipro.microservice.hm.bookingservice.services;

import com.wipro.microservice.hm.bookingservice.entities.Booking;
import com.wipro.microservice.hm.bookingservice.entities.BookingRequest;

import jakarta.validation.Valid;

public interface BookingServices {

	Booking createBooking(@Valid BookingRequest bookingRequest);

	Booking getBookingById(Long id);

}
