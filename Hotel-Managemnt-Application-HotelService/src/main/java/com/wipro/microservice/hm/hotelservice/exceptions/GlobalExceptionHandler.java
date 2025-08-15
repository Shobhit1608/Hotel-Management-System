package com.wipro.microservice.hm.hotelservice.exceptions;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;

	@ControllerAdvice
	public class GlobalExceptionHandler {

	    @ExceptionHandler(HotelNotFoundException.class)
	    public ResponseEntity<ErrorMessage> handleHotelNotFoundException(HotelNotFoundException ex) {
	    	ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "HotelNotFoundException");
	        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	    }
	}

