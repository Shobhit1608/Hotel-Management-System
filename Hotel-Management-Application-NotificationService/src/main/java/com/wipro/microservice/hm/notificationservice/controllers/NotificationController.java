package com.wipro.microservice.hm.notificationservice.controllers;

import com.wipro.microservice.hm.notificationservice.entities.Notification;
import com.wipro.microservice.hm.notificationservice.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping("/createNotification")
    public Notification create(@RequestBody Notification notification) {
        return service.create(notification);
    }

    @PostMapping("/booking/{bookingId}")
    public String sendForBooking(@PathVariable Long bookingId) {
        return service.sendForBooking(bookingId);
    }
}
