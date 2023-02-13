package com.example.sto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@Entity
@Table(name = "settlement_point")
@Getter
@Setter
public class SettlementPoint {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String pointId;

    @Column(name = "client_tin")
    private String clientTin;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "activity")
    private String activity;

    @Column(name = "object_type")
    private String objectType;

    @Column(name = "point_type")
    private String pointType;

    @Column(name = "point_format")
    private String pointFormat;

//    @Column(name = "point_address")
//    private String pointAddress;

    @Column(name = "equipment_type")
    private String equipmentType;

    @Column(name = "equipment_id")
    private String equipmentId;

}
