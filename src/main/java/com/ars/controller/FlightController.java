package com.ars.controller;

import com.ars.dto.FlightDTO;
import com.ars.exceptions.ApiException;
import com.ars.exceptions.ApiResponse;
import com.ars.service.impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;//03455953944
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightServiceImpl flightService;

    @GetMapping("/{flightId}")
    public ResponseEntity<ApiResponse<FlightDTO>> getFlight(@PathVariable Long flightId) {
        FlightDTO flightById = flightService.getFlightById(flightId);
        return ResponseEntity.ok(new ApiResponse<>(true, flightById,null));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<FlightDTO>> createFlight(@RequestBody FlightDTO flightDTO) {
        FlightDTO createFlight = flightService.saveFlight(flightDTO);
       return ResponseEntity.ok(new ApiResponse<>(true, createFlight,null));
    }
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> handleUserNotFoundException(ApiException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message: "+ ex.getMessage());
    }
}
