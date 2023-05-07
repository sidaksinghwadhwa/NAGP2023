package com.official.hotel.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
public class Hotel {

    @Getter
    @Id
    private Integer hotelId;

    @Getter
    @Column
    private String name;

    @Getter
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hotel")
    private Set<Room> rooms;

    @Getter
    @Column
    private String city;

}
