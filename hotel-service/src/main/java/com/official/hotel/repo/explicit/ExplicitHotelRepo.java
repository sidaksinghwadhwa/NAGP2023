package com.official.hotel.repo.explicit;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.official.hotel.model.Hotel;

public interface ExplicitHotelRepo {

    List<Hotel> getHotels();

    List<Hotel> getSearchedHotels(String name, String city, Date checkIn, Date checkOut);

    @Transactional
    Integer bookHotel(Integer hotelId, Integer roomId);

    Boolean checkAvailability(Integer roomId, Integer hotelId);

}
