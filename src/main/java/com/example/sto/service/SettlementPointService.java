package com.example.sto.service;

import com.example.sto.model.SettlementPoint;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SettlementPointService {
    Optional<SettlementPoint> getById(UUID id);
    //add
    void save(SettlementPoint settlementPoint);
    //update
    void update(SettlementPoint settlementPoint);
    //delete
    void delete(UUID id);
    //list
    List<SettlementPoint> getAll();
}
