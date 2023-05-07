package com.official.flight.repo;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.official.flight.model.Flight;
import com.official.flight.repo.explicit.ExplicitFlightRepo;

public interface FlightRepo extends JpaRepositoryImplementation<Flight, Integer>, ExplicitFlightRepo{


}
