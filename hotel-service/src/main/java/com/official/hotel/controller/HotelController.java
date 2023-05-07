package com.official.hotel.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.official.hotel.model.Hotel;
import com.official.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> hotelData() {

        LOGGER.info("Get All Hotels ");

        return ResponseEntity.ok(hotelService.getHotels());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> hotelData(@RequestParam("name") String name,
            @RequestParam("city") String city,
            @RequestParam("checkIn") @DateTimeFormat(pattern = "dd-MM-yyyy") Date checkIn,
            @RequestParam("checkOut") @DateTimeFormat(pattern = "dd-MM-yyyy") Date checkOut) {

        LOGGER.info("Searching hotel with name: " + name + " in city: " + city);

        return ResponseEntity.ok(hotelService.getSearchedHotels(name, city, checkIn, checkOut));
    }

    @PutMapping("/book")
    public ResponseEntity<Boolean> bookHotel(@RequestParam("hotelId") Integer hotelId,
            @RequestParam("roomId") Integer roomId) {

        LOGGER.info("Booking hotel with id: " + hotelId);

        return ResponseEntity.ok(hotelService.bookHotel(hotelId, roomId));
    }

}
