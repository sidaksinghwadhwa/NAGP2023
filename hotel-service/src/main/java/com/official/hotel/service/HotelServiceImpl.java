package com.official.hotel.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.hotel.model.Hotel;
import com.official.hotel.repo.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public List<Hotel> getHotels() {

        return hotelRepo.getHotels();
    }

    @Override
    public List<Hotel> getSearchedHotels(String name, String city, Date checkIn, Date checkOut) {

        return hotelRepo.getSearchedHotels(name, city, checkIn, checkOut);

    }

    @Override
    public Boolean bookHotel(Integer hotelId, Integer roomId) {

        if (checkAvailability(roomId, hotelId)) {
            hotelRepo.bookHotel(hotelId, roomId);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    private boolean checkAvailability(Integer seatId, Integer hotelId) {

        return hotelRepo.checkAvailability(seatId, hotelId);

    }

}
