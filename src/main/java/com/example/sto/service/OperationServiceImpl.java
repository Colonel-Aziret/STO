package com.example.sto.service;

import com.example.sto.model.Operation;
import com.example.sto.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Override
    public Operation save(Operation operation) {
        operation.setDate(new Date());
        return operationRepository.save(operation);
    }

    @Override
    public List<Operation> getAll() {
        return operationRepository.findAll();
    }
}
