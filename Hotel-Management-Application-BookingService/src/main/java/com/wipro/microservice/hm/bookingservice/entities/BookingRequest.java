package com.wipro.microservice.hm.bookingservice.entities;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookingRequest {

	   Long userId;
	    Long hotelId;
	    Long roomId;
	    LocalDate checkInDate;
	    LocalDate checkOutDate;
		
}
