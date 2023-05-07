package com.official.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.official.booking.model.Booking;
import com.official.booking.model.Booking.BookingType;
import com.official.booking.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> bookingData() {

        return ResponseEntity.ok(bookingService.getBookings());
    }

    @PostMapping("/book")
    public ResponseEntity<Boolean> addBooking(@RequestBody Booking booking) {

        // Check Inventory

        // Paid Amount
        // Booking
        // Update Inv
        // Notify USer

        if (booking.getBookingType().equals(BookingType.FLIGHT)) {

            // Check Inventory
            boolean inv = bookingService.checkFlightInventory(booking);
            System.out.println("$$$$$$ inv $$$$$$$$" + inv);
            if (inv) {
                // Paid Amount
                boolean paid = bookingService.amountPaid(booking);
                System.out.println("$$$$$$ paid $$$$$$$$" + paid);

                if (paid) {
                    bookingService.addBooking(booking);
                    // LOGGER.info("Your Booking is a Success !! Enjoy !! Booking Id: " +
                    // bookingId);
                    boolean updateInventory = bookingService.updateInventory(booking);
                    bookingService.notifySuccess();
                    // LOGGER.info("Update inv");

                    // add booking
                    // notify user
                } else {
                    // LOGGER.info("Sorry your Booking with Booking Id: " + bookingId + " failed.
                    // Refund
                    boolean refunded = bookingService.refundAmount(booking);
                    bookingService.notifyPaymentFailure();

                    // refund user
                    // notify user
                }
            } else {
                bookingService.notifyNotAvail();

                // LOGGER.info("Sorry not avail to book")

            }

        }

        return ResponseEntity.ok(bookingService.addBooking(booking));
    }

}
