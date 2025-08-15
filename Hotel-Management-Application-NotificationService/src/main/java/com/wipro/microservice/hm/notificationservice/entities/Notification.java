package com.wipro.microservice.hm.notificationservice.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor 
@AllArgsConstructor
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;    
    private Long userId;       
    private Long hotelId;      
    private String message; 
    
    @Column(name = "sent_at", columnDefinition = "DATETIME")
    private LocalDateTime sentAt;
}
