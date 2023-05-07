package com.official.booking.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.official.booking.model.Booking;
import com.official.booking.repo.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Override
    public List<Booking> getBookings() {

        return bookingRepo.getBookings();
    }

    @Override
    public Boolean addBooking(Booking booking) {

        bookingRepo.addBooking(booking);
        return Boolean.TRUE;
    }

    @Override
    public Boolean checkFlightInventory(Booking booking) {

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

        Boolean checkFlightInv = circuitBreaker.run(() -> {
            System.out.println("Circuiting");
            List<ServiceInstance> flightService = discoveryClient.getInstances("flight-service");
            URI flightServiceUri = flightService.get(0).getUri();
            System.out.println("^^^flightServiceUri^^^^" + flightServiceUri);
            return restTemplate.getForObject(
                    flightServiceUri + "/flight-service/flight/test-inventory", Boolean.class);
        }, throwable -> {
            return false;
        });
        System.out.println("****checkFlightInv***" + checkFlightInv);
        return checkFlightInv;
    }

    @Override
    public Boolean amountPaid(Booking booking) {

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

        Boolean amountPaid = circuitBreaker.run(() -> {
            System.out.println("Circuiting PaymentService :: ");
            List<ServiceInstance> paymentService = discoveryClient.getInstances("payment-service");
            URI paymentServiceUri = paymentService.get(0).getUri();
            System.out.println("^^^paymentServiceUri^^^^^" + paymentServiceUri);
            String url = paymentServiceUri
                    + "/payment-service/payment/pay?bookingAmount=2900.0&paid=true";
            System.out.println("(((_url__)))) " + url);
            return restTemplate.getForObject(url, Boolean.class);
        }, throwable -> {
            return false;
        });
        System.out.println("**** amountPaid ***" + amountPaid);
        return amountPaid;
    }

    @Override
    public Boolean updateInventory(Booking booking) {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void notifySuccess() {

        // TODO Auto-generated method stub

    }

    @Override
    public void notifyPaymentFailure() {

        // TODO Auto-generated method stub

    }

    @Override
    public void notifyNotAvail() {

        // TODO Auto-generated method stub

    }

    @Override
    public boolean refundAmount(Booking booking) {

        // TODO Auto-generated method stub
        return false;
    }

}
