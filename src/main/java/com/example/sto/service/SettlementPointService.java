package com.example.sto.service;

import com.example.sto.model.SettlementPoint;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SettlementPointService {
    Optional<SettlementPoint> getById(UUID id);
    //add
    SettlementPoint save(SettlementPoint settlementPoint);

    SettlementPoint save(SettlementPoint settlementPoint, UUID pointID);

    //update
    void update(SettlementPoint settlementPoint);
    //delete
    void delete(UUID id);
    //list
    List<SettlementPoint> getAll();

    void deleteById(UUID pointId);
}
