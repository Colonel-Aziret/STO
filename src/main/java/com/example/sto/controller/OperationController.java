package com.example.sto.controller;

import com.example.sto.model.Operation;
import com.example.sto.repository.OperationRepository;
import com.example.sto.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class OperationController {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationService operationService;

    @PostMapping(value = "/operations")
    public Operation save(@RequestBody Operation operation) {
        return operationService.save(operation);
    }
}
