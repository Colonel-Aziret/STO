package com.example.sto.service;

import com.example.sto.model.SettlementPoint;
import com.example.sto.repository.SettlementPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SettlementPointServiceImpl implements SettlementPointService {

    @Autowired
    SettlementPointRepository settlementPointRepository;

    @Override
    public Optional<SettlementPoint> getById(UUID id) {
        return settlementPointRepository.findById(id);
    }

    @Override
    public SettlementPoint save(SettlementPoint settlementPoint) {
        return null;
    }

    @Override
    public SettlementPoint save(SettlementPoint settlementPoint, UUID pointID) {
        settlementPoint.setPointId(UUID.randomUUID());
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
    public void delete(UUID pointId) {
        settlementPointRepository.deleteById(pointId);
    }

    @Override
    public void deleteById(UUID pointId) {
        settlementPointRepository.deleteById(pointId);
    }

    @Override
    public List<SettlementPoint> getAll() {
        return settlementPointRepository.findAll();
    }

}
