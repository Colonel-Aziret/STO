package com.example.sto.service;

import com.example.sto.model.Operation;
import com.example.sto.model.SettlementPoint;
import com.example.sto.repository.SettlementPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SettlementPointServiceImpl implements SettlementPointService {

    @Autowired
    SettlementPointRepository settlementPointRepository;

    @Override
    public Optional<SettlementPoint> getById(String id) {
        return settlementPointRepository.findById(id);
    }


    @Override
    public SettlementPoint save(SettlementPoint settlementPoint) {
        Operation operation = new Operation();
        operation.setDate(new Date());
        return settlementPointRepository.save(settlementPoint);
    }



    public List<String> allSettlementPoint() {
        List<SettlementPoint> pointId = settlementPointRepository.findAll();
        return allSettlementPoint();
    }

    @Override
    public void update(SettlementPoint settlementPoint) {
        settlementPointRepository.save(settlementPoint);
    }

    @Override
    public void delete(String pointId) {
        settlementPointRepository.deleteById(pointId);
    }

    @Override
    public void deleteById(String pointId) {
        settlementPointRepository.deleteById(pointId);
    }

    @Override
    public List<SettlementPoint> getAll() {
        return settlementPointRepository.findAll();
    }



}
