package com.example.sto.controller;

import com.example.sto.model.PointAddress;
import com.example.sto.model.SettlementPoint;
import com.example.sto.repository.PointAddressRepository;
import com.example.sto.service.PointAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class PointAddressController {
//    @Autowired
//    PointAddressRepository pointAddressRepository;
//
//    @Autowired
//    PointAddressService pointAddressService;
//
//    @PostMapping(value = "/add")
//    public PointAddress savePointAddress(@RequestBody PointAddress pointAddress) {
//        return pointAddressService.save(pointAddress);
//    }
//}
