package com.official.flight.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.flight.model.Flight;
import com.official.flight.model.Flight.FlightType;
import com.official.flight.repo.FlightRepo;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepo flightRepo;

    @Override
    public List<Flight> getFlights() {

        return flightRepo.getFlights();
    }

    @Override
    public List<Flight> getSearchedFlights(String arrival, String departure, String flightType,
            Date flightInputDate) {

        if (FlightType.BUSINESS.toString().equalsIgnoreCase(flightType)) {
            return flightRepo.getSearchedFlights(departure, arrival, FlightType.BUSINESS,
                    flightInputDate);
        } else {
            return flightRepo.getSearchedFlights(departure, arrival, FlightType.ECONOMY,
                    flightInputDate);
        }

    }

    @Override
    public Boolean bookFlight(Integer flightId, Integer seatId) {

        if (checkAvailability(seatId, flightId)) {
            flightRepo.bookFlight(flightId, seatId);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    private boolean checkAvailability(Integer seatId, Integer flightId) {

        return flightRepo.checkAvailability(seatId, flightId);

    }

    @Override
    public Flight getFlightById(Integer flightId) {

        return flightRepo.findById(flightId).get();
    }

}
