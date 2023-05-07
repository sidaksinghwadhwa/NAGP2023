package com.official.flight.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Entity
public class Seat {

    @Id
    @Getter
    private Integer seatId;

    @Getter
    @Column
    private String seatName;

    @Getter
    @Column
    private Boolean available;

    @Getter
    @Column(name = "flightId")
    private Integer flightId;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    @JoinColumn(name = "flightId", insertable = false, updatable = false)
    private Flight flight;

}