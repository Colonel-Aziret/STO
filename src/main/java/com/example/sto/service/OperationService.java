package com.example.sto.service;

import com.example.sto.dto.OperationDTO;
import com.example.sto.dto.SettlementPointDTO;
import com.example.sto.model.Operation;

import java.util.List;

public interface OperationService {
    Operation save(OperationDTO operationDTO);

    List<Operation> getAll();

}
