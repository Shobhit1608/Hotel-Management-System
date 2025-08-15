package com.wipro.microservice.hm.bookingservice.exceptions;

public class RoomAlreadyBookedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomAlreadyBookedException(Long roomId) {
        super("Room with ID " + roomId + " is already booked for the selected dates.");
    }
}
