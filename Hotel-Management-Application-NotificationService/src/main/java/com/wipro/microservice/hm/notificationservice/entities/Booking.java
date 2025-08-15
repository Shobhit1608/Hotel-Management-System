package com.wipro.microservice.hm.notificationservice.entities;

import lombok.Data;

@Data
public class Booking{
	private Long id;
    private Long hotelId;
    private Long roomId;
}