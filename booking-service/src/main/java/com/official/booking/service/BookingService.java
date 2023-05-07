package com.official.booking.service;

import java.util.List;

import com.official.booking.model.Booking;

public interface BookingService {

    List<Booking> getBookings();

    Boolean addBooking(Booking booking);

    Boolean checkFlightInventory(Booking booking);

    Boolean amountPaid(Booking booking);

    Boolean updateInventory(Booking booking);

    void notifySuccess();

    void notifyPaymentFailure();

    void notifyNotAvail();

    boolean refundAmount(Booking booking);
}
