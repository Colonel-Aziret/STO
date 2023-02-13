package com.example.sto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "operations")
@Getter
@Setter
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operation_id")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    private SettlementPoint settlementPoint;

    @Column(name = "date")
    private Date date;

    @Column(name = "sum")
    private Double sum;

    @Column(name = "currency")
    private String currency;

    @Column(name = "commission")
    private Double commission;

    @Column(name = "supplier_tin")
    private String supplierTin;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "nonresident_name")
    private String nonresidentName;

    @Column(name = "payment_details")
    private String paymentDetails;

    @Column(name = "payment_type")
    private Integer paymentType;
}
