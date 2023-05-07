package com.official.hotel.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Entity
public class Room {

    @Id
    @Getter
    private Integer roomId;

    @Getter
    @Column
    private String roomType;

    @Getter
    @Column
    private Integer occupancy;

    @Getter
    @Column
    private Boolean available;

    @Getter
    @Column
    private Double cost;

    // @Getter
    // @Transient
    // private List<Date> bookedDates = Arrays.asList(getDate("01-05-2023"), getDate("05-05-2023"));

    @Getter
    @Column(name = "hotelId")
    private Integer hotelId;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId", insertable = false, updatable = false)
    private Hotel hotel;

}