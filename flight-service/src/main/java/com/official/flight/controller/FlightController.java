package com.official.flight.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.official.flight.model.Flight;
import com.official.flight.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> flightData() {

        return ResponseEntity.ok(flightService.getFlights());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> flightData(@PathVariable("id") Integer flightId) {

        return ResponseEntity.ok(flightService.getFlightById(flightId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Flight>> flightData(@RequestParam("arrival") String arrival,
            @RequestParam("departure") String departure,
            @RequestParam("flightType") String flightType,
            @RequestParam("flightDate") @DateTimeFormat(
                pattern = "dd-MM-yyyy") Date flightInputDate) {

        return ResponseEntity.ok(
                flightService.getSearchedFlights(arrival, departure, flightType, flightInputDate));
    }

    @PutMapping("/book")
    public ResponseEntity<Boolean> bookFlight(@RequestParam("flightId") Integer flightId,
            @RequestParam("seatId") Integer seatId) {

        return ResponseEntity.ok(flightService.bookFlight(flightId, seatId));
    }

    @GetMapping("/test-inventory")
    public ResponseEntity<Boolean> checkInv() {

        return ResponseEntity.ok(true);
    }

}
