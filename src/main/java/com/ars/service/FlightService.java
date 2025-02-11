package com.ars.service;

import com.ars.dto.FlightDto;
import com.ars.model.Flight;

import java.util.List;

public interface FlightService {
    FlightDto addFlight(Flight flight);
    Flight updateFlight(long flightId, Flight flight);
    List<FlightDto> getAllFlights();
    Flight getFlightById(long flightId);
    List<Flight> searchFlight(String source, String destination);
    boolean checkSeatAvailability(long flightId, int requestedSeats);
    void deleteFlight(long flightId);
}
