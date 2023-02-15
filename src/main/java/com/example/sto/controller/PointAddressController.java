package com.example.sto.controller;

import com.example.sto.model.Operation;
import com.example.sto.model.PointAddress;
import com.example.sto.repository.PointAddressRepository;
import com.example.sto.service.PointAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PointAddressController {
    @Autowired
    PointAddressRepository pointAddressRepository;

    @Autowired
    PointAddressService pointAddressService;

    @PostMapping(value = "/add")
    public PointAddress savePointAddress(@RequestBody PointAddress pointAddress) {
        Operation operation = new Operation();
        operation.setDate(new Date());
        return pointAddressService.save(pointAddress);
    }
}
