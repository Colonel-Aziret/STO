package com.example.sto.service;

import com.example.sto.dto.OperationDTO;
import com.example.sto.dto.SettlementPointDTO;
import com.example.sto.model.Operation;
import com.example.sto.model.SettlementPoint;
import com.example.sto.repository.OperationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Override
    public Operation save(OperationDTO operationDTO) {
        List<OperationDTO> operations = new ArrayList<>();
        operations.add(operationDTO);
        return operationRepository.save(Operation.builder()
                .date(new Date())
                .sum(operationDTO.getSum())
                .currency(operationDTO.getCurrency())
                .commission(operationDTO.getCommission())
                .supplierTin(operationDTO.getSupplierTin())
                .supplierName(operationDTO.getSupplierName())
                .nonresidentName(operationDTO.getNonresidentName())
                .paymentDetails(operationDTO.getPaymentDetails())
                .paymentType(operationDTO.getPaymentType()).build());
    }


    @Override
    public List<Operation> getAll() {
        return operationRepository.findAll();
    }
}
