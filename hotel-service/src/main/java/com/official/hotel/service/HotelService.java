package com.official.hotel.service;

import java.util.Date;
import java.util.List;

import com.official.hotel.model.Hotel;

public interface HotelService {

    List<Hotel> getHotels();

    List<Hotel> getSearchedHotels(String name, String city, Date checkIn, Date checkOut);

    Boolean bookHotel(Integer hotelId, Integer roomId);
}
