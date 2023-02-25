package com.example.sto.dto;

import com.example.sto.model.Operation;
import com.example.sto.model.PointAddress;
import lombok.Data;

import java.util.List;

@Data
public class SettlementPointDTO {
    private String clientTin;

    private String clientName;

    private String activity;

    private String objectType;

    private String pointType;

    private String pointFormat;

    private String equipmentType;

    private String equipmentId;

    private PointAddress pointAddress;

    private List<Operation> operations;
}
