package com.ars.service.impl;

import com.ars.dto.FlightDTO;
import com.ars.exceptions.FlightNotFoundException;
import com.ars.model.Flight;
import com.ars.mapper.FlightMapper;
import com.ars.repository.FlightRepository;
import com.ars.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public FlightDTO getFlightById(Long flightId) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new FlightNotFoundException("Flight not found ID : " + flightId));
        return FlightMapper.toDTO(flight);
    }

    @Override
    public FlightDTO saveFlight(FlightDTO flightDTO) {
        Flight flight = FlightMapper.toEntity(flightDTO);
        flight = flightRepository.save(flight);
        return FlightMapper.toDTO(flight);
    }
}