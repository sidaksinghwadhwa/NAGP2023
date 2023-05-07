package com.official.flight.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
public class Flight {

    public enum FlightType {
        ECONOMY, BUSINESS
    }

    @Getter
    @Id
    private Integer flightId;

    @Getter
    @Column
    private String airline;

    @Getter
    @Column
    private Double cost;

    @Getter
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "flight")
    private Set<Seat> seats;

    @Getter
    @Column
    private String departure;

    @Getter
    @Column
    private String arrival;

    @Getter
    @Column
    @Enumerated(EnumType.STRING)
    private FlightType flightType;

    @Getter
    @Column
    private Date flightStart;

    @Getter
    @Column
    private Date flightEnd;

}
