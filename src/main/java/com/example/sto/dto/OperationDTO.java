package com.example.sto.dto;

import com.example.sto.model.Operation;
import com.example.sto.model.SettlementPoint;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OperationDTO extends SettlementPointDTO{
    SettlementPointDTO settlementPointDTO = new SettlementPointDTO();
    private Date date;

    private Double sum;

    private String currency;

    private Double commission;

    private String supplierTin;

    private String supplierName;

    private String nonresidentName;

    private String paymentDetails;

    private Integer paymentType;

    private String pointId;

//    private SettlementPoint settlementPoint;


}
