package com.ars.mapper;

import com.ars.dto.FlightDto;
import com.ars.model.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {
    public FlightDto toDto(Flight flight) {
        return FlightDto.builder()
                .id(flight.getId())
                .airline(flight.getAirline())
                .source(flight.getSource())
                .destination(flight.getDestination())
                .departureTime(flight.getDepartureTime())
                .arrivalTime(flight.getArrivalTime())
                .availableSeats(flight.getAvailableSeats())
                .price(flight.getPrice())
                .build();
    }

    public Flight toEntity(FlightDto dto) {
        return Flight.builder()
                .id(dto.getId())
                .airline(dto.getAirline())
                .source(dto.getSource())
                .destination(dto.getDestination())
                .departureTime(dto.getDepartureTime())
                .arrivalTime(dto.getArrivalTime())
                .availableSeats(dto.getAvailableSeats())
                .price(dto.getPrice())
                .build();
    }
}
