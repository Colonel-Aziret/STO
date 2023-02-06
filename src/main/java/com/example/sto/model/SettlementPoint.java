package com.example.sto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "settlement_point")
@Getter
@Setter
public class SettlementPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "point_id_seq")
    @SequenceGenerator(name = "point_id_seq", sequenceName = "point_id_seq", allocationSize = 1)
    private UUID pointId;

    @Column(name = "client_tin")
    private String clientTin;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "activity")
    private Integer activity;

    @Column(name = "object_type")
    private Integer objectType;

    @Column(name = "point_type")
    private String pointType;

    @Column(name = "point_format")
    private String pointFormat;

    @Column(name = "point_address")
    private String pointAddress;

    @Column(name = "equipment_type")
    private String equipmentType;

    @Column(name = "equipment_id")
    private String equipmentId;

}
