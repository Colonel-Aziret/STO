package com.example.sto.service;

import com.example.sto.dto.PointAddressDTO;
import com.example.sto.dto.SettlementPointDTO;
import com.example.sto.model.SettlementPoint;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SettlementPointService {
    Optional<SettlementPoint> getById(String id);

    //add
    SettlementPoint save(SettlementPointDTO settlementPointDTO);

    //update
    void update(SettlementPoint settlementPoint);

    //delete
    void delete(String id);

    //list
    List<SettlementPoint> getAll();

    void deleteById(String pointId);
}
