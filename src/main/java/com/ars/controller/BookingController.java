package com.ars.controller;

import com.ars.dto.BookingDTO;
import com.ars.exceptions.ApiException;
import com.ars.exceptions.ApiResponse;
import com.ars.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/{bookingId}")
    public ResponseEntity<ApiResponse<BookingDTO>> getBooking(@PathVariable int bookingId) {
        BookingDTO getBookingById = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(new ApiResponse<>(true, getBookingById, null));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BookingDTO>> createBooking(@RequestBody BookingDTO bookingDTO) {
        BookingDTO createBooking= bookingService.saveBooking(bookingDTO);
        return ResponseEntity.ok(new ApiResponse<>(true, createBooking, null));
    }
}