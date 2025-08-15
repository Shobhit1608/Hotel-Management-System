package com.wipro.microservice.hm.notificationservice.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.wipro.microservice.hm.notificationservice.entities.Booking;
import com.wipro.microservice.hm.notificationservice.entities.Notification;
import com.wipro.microservice.hm.notificationservice.feign.BookingClient;
import com.wipro.microservice.hm.notificationservice.repositories.NotificationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;
    private final BookingClient bookingClient;

    @Override
    public Notification create(Notification notification) {
        notification.setSentAt(LocalDateTime.now());
        return repository.save(notification);
    }

    @Override
    public String sendForBooking(Long bookingId) {
        Booking booking = bookingClient.getBookingById(bookingId);

        String message = "Your booking is confirmed with Booking ID: " +
                booking.getId() +
                ", Hotel ID: " + booking.getHotelId() +
                ", Room ID: " + booking.getRoomId();
        			
        Notification notification = new Notification();
        notification.setBookingId(booking.getId());
        notification.setHotelId(booking.getHotelId());
        notification.setUserId(0L); 
        notification.setMessage(message);
        notification.setSentAt(LocalDateTime.now());

        repository.save(notification);

        return message;
    }
}
