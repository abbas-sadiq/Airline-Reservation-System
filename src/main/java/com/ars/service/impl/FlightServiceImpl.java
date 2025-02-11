package com.ars.service.impl;

import com.ars.dto.FlightDto;
import com.ars.mapper.FlightMapper;
import com.ars.model.Flight;
import com.ars.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl {
    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    public List<FlightDto> getAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    public FlightDto getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + id));
        return flightMapper.toDto(flight);
    }

    public FlightDto addFlight(FlightDto flightDto) {
        Flight flight = flightMapper.toEntity(flightDto);
        Flight savedFlight = flightRepository.save(flight);
        return flightMapper.toDto(savedFlight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
