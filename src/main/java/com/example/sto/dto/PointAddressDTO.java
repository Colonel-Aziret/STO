package com.example.sto.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class PointAddressDTO {
    private Integer postalCode;

    private String country;

    private String administrativeArea;

    private String locality;

    private String route;

    private String streetNumber;

    private String location;
}
