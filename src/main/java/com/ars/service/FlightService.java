package com.ars.service;

import com.ars.model.Flight;
import org.springframework.core.annotation.MergedAnnotations;

import java.util.List;

public interface FlightService {
    Flight addFlight(Flight flight);
    Flight updateFlight(long flightId, Flight flight);
    List<Flight> getAllFlights();
    Flight getFlightById(long flightId);
    List<Flight> searchFlight(String source, String destination);
    boolean checkSeatAvailability(long flightId, int requestedSeats);
    void deleteFlight(long flightId);
}
