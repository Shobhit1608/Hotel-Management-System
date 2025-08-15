package com.wipro.microservice.hm.hotelservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotelId")
    private Long id;

    @NotBlank(message = "Hotel name is required")
    private String hotelname;
    
    @NotBlank(message = "Location is required")
    private String location;
    
    private String category;
    
    @Min(value = 0)
    private int availableRooms;
    
    private boolean available;
    private double pricePerNight;
}
