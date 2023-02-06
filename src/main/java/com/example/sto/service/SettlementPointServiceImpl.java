package com.example.sto.service;

import com.example.sto.model.PointAddress;
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
    public void save(SettlementPoint settlementPoint) {
        SettlementPoint sp = new SettlementPoint();
        PointAddress pointAddress = new PointAddress();
        settlementPoint.setClientTin(settlementPoint.getClientTin());
        settlementPoint.setClientName(settlementPoint.getClientName());
        settlementPoint.setActivity(settlementPoint.getActivity());
        settlementPoint.setObjectType(settlementPoint.getObjectType());
        settlementPoint.setPointType(settlementPoint.getPointType());
        settlementPoint.setPointFormat(settlementPoint.getPointFormat());
        settlementPoint.setPointAddress(settlementPoint.getPointAddress());
        pointAddress.setPostalCode(pointAddress.getPostalCode());
        pointAddress.setCountry(pointAddress.getCountry());
        pointAddress.setAdministrativeArea(pointAddress.getAdministrativeArea());
        pointAddress.setRegion(pointAddress.getRegion());
        pointAddress.setLocality(pointAddress.getLocality());
        pointAddress.setRoute(pointAddress.getRoute());
        pointAddress.setStreetNumber(pointAddress.getStreetNumber());
        pointAddress.setLocation(pointAddress.getLocation());
        settlementPoint.setEquipmentType(settlementPoint.getEquipmentType());
        settlementPoint.setEquipmentId(settlementPoint.getEquipmentId());
        settlementPointRepository.save(settlementPoint);
    }

    @Override
    public void update(SettlementPoint settlementPoint) {
        settlementPointRepository.save(settlementPoint);
    }

    @Override
    public void delete(UUID id) {
        settlementPointRepository.deleteById(id);
    }

    @Override
    public List<SettlementPoint> getAll() {
        return settlementPointRepository.findAll();
    }
}
