package com.example.sto.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "settlement_point")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettlementPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "point_id")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
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

    @Column(name = "equipment_type")
    private String equipmentType;

    @Column(name = "equipment_id")
    private String equipmentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "point_address_id")
    private PointAddress pointAddress;

    @OneToMany(mappedBy = "settlementPoint", cascade = CascadeType.ALL)
    private List<Operation> operations;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Operation> operation;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Operation operation;

}
