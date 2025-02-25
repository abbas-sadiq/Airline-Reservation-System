package com.ars.service;

import com.ars.dto.FlightDTO;

public interface FlightService {
    FlightDTO getFlightById(Long flightId);
    FlightDTO saveFlight(FlightDTO flightDTO);
}