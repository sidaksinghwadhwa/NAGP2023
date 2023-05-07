package com.official.flight.service;

import java.util.Date;
import java.util.List;

import com.official.flight.model.Flight;

public interface FlightService {

    List<Flight> getFlights();

    List<Flight> getSearchedFlights(String arrival, String departure, String flightType,
            Date flightInputDate);

    Boolean bookFlight(Integer flightId, Integer seatId);

    Flight getFlightById(Integer flightId);
}
