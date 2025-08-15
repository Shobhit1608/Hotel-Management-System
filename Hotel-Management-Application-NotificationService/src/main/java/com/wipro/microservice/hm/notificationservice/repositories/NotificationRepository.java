package com.wipro.microservice.hm.notificationservice.repositories;

import com.wipro.microservice.hm.notificationservice.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
