package com.example.sto.controller;

import com.example.sto.dto.PointAddressDTO;
import com.example.sto.model.Operation;
import com.example.sto.model.PointAddress;
import com.example.sto.model.SettlementPoint;
import com.example.sto.repository.PointAddressRepository;
import com.example.sto.service.PointAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class PointAddressController {
    @Autowired
    PointAddressRepository pointAddressRepository;

    @Autowired
    PointAddressService pointAddressService;

    @PostMapping(value = "/add")
    public ResponseEntity<PointAddress> savePointAddress(@RequestBody PointAddressDTO pointAddressDTO) {
        return new ResponseEntity<>(pointAddressService.save(pointAddressDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<PointAddress> update(@PathVariable(value = "id") Integer id,
                                               @RequestBody PointAddress pointAddressDetails) throws ResourceNotFoundException {
        PointAddress pointAddress = pointAddressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PointAddress not found for this id :: " + id));
        pointAddress.setPostalCode(pointAddressDetails.getPostalCode());
        pointAddress.setCountry(pointAddressDetails.getCountry());
        pointAddress.setAdministrativeArea(pointAddressDetails.getAdministrativeArea());
        pointAddress.setLocality(pointAddressDetails.getLocality());
        pointAddress.setRoute(pointAddressDetails.getRoute());
        pointAddress.setStreetNumber(pointAddressDetails.getStreetNumber());
        pointAddress.setLocation(pointAddressDetails.getLocation());
        pointAddressRepository.save(pointAddress);
        return ResponseEntity.ok().body(pointAddress);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deletePointAddress(@PathVariable(value = "id") Integer id) {
        this.pointAddressRepository.deleteById(id);
        return ResponseEntity.ok().body(id);
    }
}
