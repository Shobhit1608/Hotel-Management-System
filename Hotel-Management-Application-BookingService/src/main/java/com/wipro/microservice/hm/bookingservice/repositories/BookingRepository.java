package com.wipro.microservice.hm.bookingservice.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.microservice.hm.bookingservice.entities.Booking;
public interface BookingRepository extends JpaRepository<Booking,Long> {

	@Query("SELECT b FROM Booking b " +
		       "WHERE b.roomId = ?1 " +
		       "AND (b.checkInDate <= ?3 AND b.checkOutDate >= ?2)")
		List<Booking> findBookingsForRoom(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);


}
