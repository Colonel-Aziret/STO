package com.example.sto.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "operations")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operation_id")
    @SequenceGenerator(name = "operation_id", sequenceName = "operation_id", allocationSize = 1)
    private Integer id;

//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    private String pointId;

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

    @ManyToOne
    @JoinColumn(name = "point_id")
    private SettlementPoint settlementPoint;

}
