package com.ars.service;

import com.ars.dto.BookingDTO;

public interface BookingService {
    BookingDTO getBookingById(int bookingId);
    BookingDTO saveBooking(BookingDTO bookingDTO);
}