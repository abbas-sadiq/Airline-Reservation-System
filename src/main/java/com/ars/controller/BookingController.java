package com.ars.controller;

import com.ars.dto.BookingDTO;
import com.ars.service.BookingService;
import com.ars.service.impl.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingServiceImpl bookingService;

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable int bookingId) {
        return ResponseEntity.ok(bookingService.getBookingById(bookingId));
    }

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.saveBooking(bookingDTO));
    }
}