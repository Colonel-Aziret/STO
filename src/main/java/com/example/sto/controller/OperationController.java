package com.example.sto.controller;

import com.example.sto.dto.OperationDTO;
import com.example.sto.dto.SettlementPointDTO;
import com.example.sto.model.Operation;
import com.example.sto.model.PointAddress;
import com.example.sto.model.SettlementPoint;
import com.example.sto.repository.OperationRepository;
import com.example.sto.repository.SettlementPointRepository;
import com.example.sto.service.OperationService;
import com.example.sto.service.SettlementPointService;
import org.aspectj.bridge.Message;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OperationController {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationService operationService;

    @Autowired
    SettlementPointRepository settlementPointRepository;

    @Autowired
    SettlementPointService settlementPointService;

    @PostMapping(value = "/operations")
    public ResponseEntity<Operation> save(@RequestBody OperationDTO operationDTO, SettlementPoint settlementPoint) {
//        settlementPointService.save(settlementPoint);
//        operationRepository.saveAll(settlementPoint.getOperations());
//        operationRepository.saveAll(settlementPointDTO.getOperations());
        return new ResponseEntity<>(operationService.save(operationDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/operations/update/{id}")
    public ResponseEntity<Operation> update(@PathVariable(value = "id") Integer id,
                                            @RequestBody Operation operationDetails) throws ResourceNotFoundException {
        Operation operation = operationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Operations not found for this id :: " + id));
        operation.setDate(new Date());
        operation.setSum(operationDetails.getSum());
        operation.setCurrency(operationDetails.getCurrency());
        operation.setCommission(operationDetails.getCommission());
        operation.setSupplierTin(operationDetails.getSupplierTin());
        operation.setSupplierName(operationDetails.getSupplierName());
        operation.setNonresidentName(operationDetails.getNonresidentName());
        operation.setPaymentDetails(operationDetails.getPaymentDetails());
        operation.setPaymentType(operationDetails.getPaymentType());
        operationRepository.save(operation);
        return ResponseEntity.ok().body(operation);
    }

    @DeleteMapping("/operations/delete/{id}")
    public ResponseEntity<Integer> deleteOperation(@PathVariable(value = "id") Integer id) {
        this.operationRepository.deleteById(id);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/operations/list")
    public List<Operation> getAll() {
        return operationRepository.findAll();
    }
}
