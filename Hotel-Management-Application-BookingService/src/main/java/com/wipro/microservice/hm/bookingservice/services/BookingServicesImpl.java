package com.wipro.microservice.hm.bookingservice.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.microservice.hm.bookingservice.entities.Booking;
import com.wipro.microservice.hm.bookingservice.entities.BookingRequest;
import com.wipro.microservice.hm.bookingservice.entities.BookingStatus;
import com.wipro.microservice.hm.bookingservice.exceptions.RoomAlreadyBookedException;
import com.wipro.microservice.hm.bookingservice.exceptions.RoomNotAvailableException;
import com.wipro.microservice.hm.bookingservice.feign.NotificationClient;
import com.wipro.microservice.hm.bookingservice.feign.RoomClient;
import com.wipro.microservice.hm.bookingservice.repositories.BookingRepository;
import com.wipro.microservice.hm.roomservice.entities.Room;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingServicesImpl implements BookingServices {

    private final BookingRepository bookingRepository;
    private final RoomClient roomClient;
    private final NotificationClient notificationClient;
    
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id));
    }


    @Override
    public Booking createBooking(BookingRequest bookingRequest) {

        Room room = roomClient.getRoomById(bookingRequest.getRoomId());

        if (room == null || !room.isAvailable()) {
            throw new RoomNotAvailableException(bookingRequest.getHotelId());
        }

        List<Booking> existingBookings = bookingRepository.findBookingsForRoom(
                bookingRequest.getRoomId(),
                bookingRequest.getCheckInDate(),
                bookingRequest.getCheckOutDate()
        );

        if (!existingBookings.isEmpty()) {
            throw new RoomAlreadyBookedException(bookingRequest.getRoomId());
        }

        Booking booking = new Booking();
        booking.setUserId(bookingRequest.getUserId());
        booking.setHotelId(bookingRequest.getHotelId());
        booking.setRoomId(bookingRequest.getRoomId());
        booking.setCheckInDate(bookingRequest.getCheckInDate());
        booking.setCheckOutDate(bookingRequest.getCheckOutDate());
        booking.setBookingDate(LocalDate.now());
        booking.setStatus(BookingStatus.CONFIRMED);

        long numberOfNights = bookingRequest.getCheckInDate()
                .until(bookingRequest.getCheckOutDate())
                .getDays();
        booking.setTotalPrice(room.getPricePerNight() * numberOfNights);

        Booking savedBooking = bookingRepository.save(booking);
        
       
		notificationClient.sendBookingConfirmation(savedBooking.getId());

        return savedBooking;
    }

  }

