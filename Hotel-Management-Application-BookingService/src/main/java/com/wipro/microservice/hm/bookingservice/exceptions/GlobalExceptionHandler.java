package com.wipro.microservice.hm.bookingservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RoomAlreadyBookedException.class)
    public ResponseEntity<ErrorMessage> handleRoomAlreadyBooked(RoomAlreadyBookedException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "RoomAlreadyBookedException");
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RoomNotAvailableException.class)
    public ResponseEntity<ErrorMessage> handleRoomNotAvailable(RoomNotAvailableException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "RoomNotAvailableException");
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
