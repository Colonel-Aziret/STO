package com.example.sto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "point_address")
@Getter
@Setter
public class PointAddress {
    @Id
    @GeneratedValue(generator = "operations_id")
    @GenericGenerator(name = "operations_id", strategy = "operations_id")
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

    @Column(name = "locality")
    private String locality;

    @Column(name = "route")
    private String route;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "location")
    private String location;
}
