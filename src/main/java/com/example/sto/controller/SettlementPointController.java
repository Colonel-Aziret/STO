package com.example.sto.controller;

import com.example.sto.model.PointAddress;
import com.example.sto.model.SettlementPoint;
import com.example.sto.service.PointAddressService;
import com.example.sto.service.SettlementPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class SettlementPointController {

    @Autowired
    SettlementPointService settlementPointService;

    @Autowired
    PointAddressService pointAddressService;

    // Регистрация точки расчета
    @RequestMapping(value = "/point/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = "application/json")
    public ResponseEntity<SettlementPoint> saveSettlementPoint(@RequestBody SettlementPoint settlementPoint, PointAddress pointAddress) {
//        if (settlementPoint == null) {
//            return new ResponseEntity<SettlementPoint>(HttpStatus.BAD_REQUEST);
//        }
//        SettlementPoint sp = new SettlementPoint();
//        PointAddress pa = new PointAddress();
//        settlementPoint.setClientTin(settlementPoint.getClientTin());
//        settlementPoint.setClientName(settlementPoint.getClientName());
//        settlementPoint.setActivity(settlementPoint.getActivity());
//        settlementPoint.setObjectType(settlementPoint.getObjectType());
//        settlementPoint.setPointType(settlementPoint.getPointType());
//        settlementPoint.setPointFormat(settlementPoint.getPointFormat());
//        settlementPoint.setPointAddress(settlementPoint.getPointAddress());
//        pointAddress.setPostalCode(pointAddress.getPostalCode());
//        pointAddress.setCountry(pointAddress.getCountry());
//        pointAddress.setAdministrativeArea(pointAddress.getAdministrativeArea());
//        pointAddress.setRegion(pointAddress.getRegion());
//        pointAddress.setLocality(pointAddress.getLocality());
//        pointAddress.setRoute(pointAddress.getRoute());
//        pointAddress.setStreetNumber(pointAddress.getStreetNumber());
//        pointAddress.setLocation(pointAddress.getLocation());
//        settlementPoint.setEquipmentType(settlementPoint.getEquipmentType());
//        settlementPoint.setEquipmentId(settlementPoint.getEquipmentId());
        this.settlementPointService.save(settlementPoint);
        return new ResponseEntity<SettlementPoint>(settlementPoint, HttpStatus.OK);
    }

    // Изменение регистрационных параметров точки расчета
    @RequestMapping(value = "/point/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = "application/json")
    public ResponseEntity<SettlementPoint> updateSettlementPoint(@RequestBody @Validated SettlementPoint settlementPoint) {
        HttpHeaders headers = new HttpHeaders();
//        if (settlementPoint == null) {
//            return new ResponseEntity<SettlementPoint>(HttpStatus.BAD_REQUEST);
//        }
        this.settlementPointService.update(settlementPoint);
        return new ResponseEntity<SettlementPoint>(settlementPoint, headers, HttpStatus.CREATED);
    }

    // Снятие с регистрации точки расчета
    @RequestMapping(value = "/point/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = "application/json")
    public ResponseEntity<SettlementPoint> deleteSettlementPoint(@PathVariable("id") UUID id) {
        Optional<SettlementPoint> settlementPoint = this.settlementPointService.getById(id);
        if (settlementPoint == null) {
            return new ResponseEntity<SettlementPoint>(HttpStatus.NOT_FOUND);
        }
        this.settlementPointService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/point/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = "application/json")
    public ResponseEntity<List<SettlementPoint>> getAllSettlementPoints() {
        List<SettlementPoint> customers = this.settlementPointService.getAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<List<SettlementPoint>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<SettlementPoint>>(customers, HttpStatus.OK);
    }
}

