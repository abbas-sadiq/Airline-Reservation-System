package com.ars.service.impl;

import com.ars.dto.BookingDTO;
import com.ars.exceptions.ApiException;
import com.ars.model.Booking;
import com.ars.model.User;
import com.ars.model.Flight;
import com.ars.mapper.BookingMapper;
import com.ars.repository.BookingRepository;
import com.ars.repository.UserRepository;
import com.ars.repository.FlightRepository;
import com.ars.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public BookingDTO getBookingById(int id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(()-> new ApiException("Booking not found"));
        return BookingMapper.toDTO(booking);
    }

    @Override
    public BookingDTO saveBooking(BookingDTO bookingDTO) {
        User user = userRepository.findById(bookingDTO.getUserId()).orElseThrow(() -> new ApiException("User not found ID: " + bookingDTO.getUserId()));
        Flight flight = flightRepository.findById(bookingDTO.getFlightId()).orElseThrow(() -> new ApiException("Flight not found ID: " + bookingDTO.getFlightId()));
        Booking booking = BookingMapper.toEntity(bookingDTO, user, flight);
        booking = bookingRepository.save(booking);
        return BookingMapper.toDTO(booking);

    }
}