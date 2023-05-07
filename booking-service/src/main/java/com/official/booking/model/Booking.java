package com.official.booking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Booking {

    public enum BookingType {
        FLIGHT, HOTEL
    };

    @Id
    @GeneratedValue
    private Integer bookingId;

    @Setter
    @Column
    private Double bookingAmount;

    @Setter
    @Column
    private String customerName;

    @Setter
    @Column
    private String mobile;

    @Setter
    @Column
    private String address;

    @Setter
    @Column
    @Enumerated(EnumType.STRING)
    private BookingType bookingType;

    @Setter
    @Column
    private Integer flightId;

    @Setter
    @Column
    private Integer hotelId;

    @Setter
    @Column
    private String roomIdsCsv;

    @Setter
    @Column
    private String seatIdsCsv;

    @Setter
    @Column
    private Date startDate;

    @Setter
    @Column
    private Date endDate;

}
