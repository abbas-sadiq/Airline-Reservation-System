package com.ars.mapper;

import com.ars.dto.FlightDTO;
import com.ars.model.Flight;

public class FlightMapper {
    public static FlightDTO toDTO(Flight flight) {
        FlightDTO dto = new FlightDTO();
        dto.setFlightId(flight.getFlightId());
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setDepartureCity(flight.getDepartureCity());
        dto.setDestinationCity(flight.getDestinationCity());
        dto.setAvailableSeats(flight.getAvailableSeats());
        return dto;
    }

    public static Flight toEntity(FlightDTO dto) {
        Flight flight = new Flight();
        flight.setFlightId(dto.getFlightId());
        flight.setFlightNumber(dto.getFlightNumber());
        flight.setDepartureCity(dto.getDepartureCity());
        flight.setDestinationCity(dto.getDestinationCity());
        flight.setAvailableSeats(dto.getAvailableSeats());
        return flight;
    }
}