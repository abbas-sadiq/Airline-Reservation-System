package com.ars.mapper;

import com.ars.dto.BookingDTO;
import com.ars.model.Booking;
import com.ars.model.User;
import com.ars.model.Flight;

public class BookingMapper {
    public static BookingDTO toDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setBookingId(booking.getId());
        dto.setUserId(booking.getUser().getUserId());
        dto.setFlightId(booking.getFlight().getFlightId());
        dto.setSeatNumber(booking.getSeatNumber());
        return dto;
    }

    public static Booking toEntity(BookingDTO dto, User user, Flight flight) {
        Booking booking = new Booking();
        booking.setId(dto.getBookingId());
        booking.setUser(user);
        booking.setFlight(flight);
        booking.setSeatNumber(dto.getSeatNumber());
        return booking;
    }
}