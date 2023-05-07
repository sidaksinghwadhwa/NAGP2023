package com.official.flight.repo.explicit;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.official.flight.model.Flight;
import com.official.flight.model.Flight.FlightType;

public interface ExplicitFlightRepo {

    List<Flight> getFlights();

    List<Flight> getSearchedFlights(String departure, String arrival, FlightType flightType,
            Date flightInputDate);

    @Transactional
    Integer bookFlight(Integer flightId, Integer seatId);

    Boolean checkAvailability(Integer seatId, Integer flightId);

}
