package com.example.sto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "point_address")
@Getter
@Setter
public class PointAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_address_id")
    private Integer id;


    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "administrative_area")
    private String administrativeArea;

//    @Column(name = "region")
//    private String region;

    @Column(name = "locality")
    private String locality;

    @Column(name = "route")
    private String route;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "location")
    private String location;

}
