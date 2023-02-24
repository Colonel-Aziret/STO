package com.example.sto.service;

import com.example.sto.dto.PointAddressDTO;
import com.example.sto.dto.SettlementPointDTO;
import com.example.sto.model.Operation;
import com.example.sto.model.SettlementPoint;
import com.example.sto.repository.OperationRepository;
import com.example.sto.repository.PointAddressRepository;
import com.example.sto.repository.SettlementPointRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SettlementPointServiceImpl implements SettlementPointService {

    @Autowired
    SettlementPointRepository settlementPointRepository;
    @Autowired
    PointAddressRepository pointAddressRepository;
    @Autowired
    PointAddressService pointAddressService;
    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Optional<SettlementPoint> getById(String id) {
        return settlementPointRepository.findById(id);
    }


    @Override
    public SettlementPoint save(SettlementPointDTO settlementPointDTO) {
        return settlementPointRepository.save(SettlementPoint.builder()
                .clientTin(settlementPointDTO.getClientTin())
                .clientName(settlementPointDTO.getClientName())
                .activity(settlementPointDTO.getActivity())
                .objectType(settlementPointDTO.getObjectType())
                .pointType(settlementPointDTO.getPointType())
                .pointFormat(settlementPointDTO.getPointFormat())
                .equipmentType(settlementPointDTO.getEquipmentType())
                .equipmentId(settlementPointDTO.getEquipmentId())
                .pointAddress(settlementPointDTO.getPointAddress()).build());
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
