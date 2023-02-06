package com.example.sto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "point_address")
@Getter
@Setter
public class PointAddress {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "point_id")
    private SettlementPoint pointId;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "administrative_area")
    private String administrativeArea;

    @Column(name = "region")
    private String region;

    @Column(name = "locality")
    private String locality;

    @Column(name = "route")
    private String route;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "location")
    private String location;
}
