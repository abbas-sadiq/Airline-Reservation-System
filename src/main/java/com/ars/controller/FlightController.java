package com.ars.controller;

import com.ars.dto.FlightDto;
import com.ars.model.Flight;
import com.ars.service.FlightService;
import com.ars.service.impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    @Autowired
    private FlightServiceImpl flightService;

    @PostMapping
    public FlightDto addFlight(@RequestBody FlightDto flightDto) {
        return flightService.addFlight(flightDto);


    }




}
