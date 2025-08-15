package com.wipro.microservice.hm.roomservice.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private Long id;

    @NotBlank(message = "Room number is required")
    private String roomNumber;

    @Min(value = 100, message = "Price must be positive")
    private double pricePerNight;

    private boolean available;

    private Long hotelId; 
    private Long userId; 
}