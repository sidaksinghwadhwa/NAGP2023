package com.official.booking.repo;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.official.booking.model.Booking;
import com.official.booking.repo.explicit.ExplicitBookingRepo;

public interface BookingRepo extends JpaRepositoryImplementation<Booking, Integer>, ExplicitBookingRepo{


}
