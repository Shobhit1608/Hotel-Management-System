package com.wipro.microservice.hm.notificationservice.services;

import com.wipro.microservice.hm.notificationservice.entities.Notification;

public interface NotificationService {

	Notification create(Notification notification);

	String sendForBooking(Long id);

}
