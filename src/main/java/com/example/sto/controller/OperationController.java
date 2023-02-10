package com.example.sto.controller;

import com.example.sto.model.Operation;
import com.example.sto.model.SettlementPoint;
import com.example.sto.repository.OperationRepository;
import com.example.sto.service.OperationService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OperationController {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationService operationService;

    @PostMapping(value = "/operations")
    public List<Operation> save(@RequestBody Operation operation) {
        return operationService.save(operation);
    }
}
