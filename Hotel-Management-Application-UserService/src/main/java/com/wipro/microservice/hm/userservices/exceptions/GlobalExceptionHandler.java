package com.wipro.microservice.hm.userservices.exceptions;


	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;

	@ControllerAdvice
	public class GlobalExceptionHandler {

	    @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException ex) {
	        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "UserNotFoundException");
	        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	    }
	}

