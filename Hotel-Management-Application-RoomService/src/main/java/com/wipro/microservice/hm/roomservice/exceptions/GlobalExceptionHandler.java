package com.wipro.microservice.hm.roomservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

	@ExceptionHandler(RoomNotAvailableException.class)
	public ResponseEntity<ErrorMessage> handleRoomNotFoundException(RoomNotAvailableException ex) {
	    ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "RoomNotAvailableException");
	    return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
}
}