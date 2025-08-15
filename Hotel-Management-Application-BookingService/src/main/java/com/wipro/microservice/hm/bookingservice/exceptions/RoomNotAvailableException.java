package com.wipro.microservice.hm.bookingservice.exceptions;

public class RoomNotAvailableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomNotAvailableException(Long hotelId) {
	    super("Room not available in hotel with ID: " + hotelId);
	}
}
