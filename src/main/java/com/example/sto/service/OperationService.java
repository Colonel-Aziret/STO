package com.example.sto.service;

import com.example.sto.model.Operation;

import java.util.List;

public interface OperationService {
    Operation save(Operation operation);
    List<Operation> getAll();

}
