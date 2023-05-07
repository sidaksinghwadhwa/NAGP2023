package com.official.booking.repo.explicit;

import java.util.List;

import javax.transaction.Transactional;

import com.official.booking.model.Booking;

public interface ExplicitBookingRepo {

    List<Booking> getBookings();

    @Transactional
    Integer addBooking(Booking booking);

}
