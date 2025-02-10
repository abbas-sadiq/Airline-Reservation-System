package com.ars.service.impl;


import com.ars.dto.FlightDto;
import com.ars.mapper.FlightMapper;
import com.ars.model.Flight;
import com.ars.repository.FlightRepository;
import com.ars.service.FlightService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired private FlightMapper flightMapper;
    @Autowired private FlightRepository flightRepository;

    @Override

    public FlightDto addFlight(Flight flight) {
        Flight entity = flightRepository.save(flight);
        return flightMapper.map(entity);
    }
    @Override
    public Flight updateFlight(long flightId, Flight flight) {
        flight.setId(flightId);
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    @Override
    public Flight getFlightById(long flightId) {
        flightId = flightRepository.findById(flightId).get().getId();
        return flightRepository.findById(flightId).get();
    }
    @Override
    public List<Flight> searchFlight(String source, String destination) {
        return flightRepository.findBySourceAndDestination(source, destination);
    }

    @Override
    public boolean checkSeatAvailability(long flightId , int requestedSeats){
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        return flight.getAvailableSeats() >= requestedSeats;

    }

    @Override
    public void deleteFlight(long flightId) {
        if (!flightRepository.existsById(flightId)) {
            throw new EntityNotFoundException("Flight not found with ID: " + flightId);
        }
        flightRepository.deleteById(flightId);
    }





}
