package com.ars.controller;

import com.ars.dto.FlightDTO;
import com.ars.service.impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightServiceImpl flightService;

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable Long flightId) {
        return ResponseEntity.ok(flightService.getFlightById(flightId));
    }

    @PostMapping
    public ResponseEntity<FlightDTO> createFlight(@RequestBody FlightDTO flightDTO) {
       return ResponseEntity.ok(flightService.saveFlight(flightDTO));
    }
}