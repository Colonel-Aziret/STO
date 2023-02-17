package com.example.sto.controller;

import com.example.sto.model.Operation;
import com.example.sto.model.PointAddress;
import com.example.sto.model.SettlementPoint;
import com.example.sto.repository.OperationRepository;
import com.example.sto.repository.PointAddressRepository;
import com.example.sto.repository.SettlementPointRepository;
import com.example.sto.service.OperationService;
import com.example.sto.service.PointAddressService;
import com.example.sto.service.SettlementPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/point")
public class SettlementPointController {
    @Autowired
    SettlementPointRepository settlementPointRepository;
    @Autowired
    SettlementPointService settlementPointService;

    @Autowired
    PointAddressRepository pointAddressRepository;

    @Autowired
    PointAddressService pointAddressService;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    OperationService operationService;


    // Регистрация точки расчета
//    @RequestMapping(value = "/api/point/add", method = RequestMethod.GET)
//    public ModelAndView addSettlementPoint() {
//        ModelAndView modelAndView = new ModelAndView("addSettlementPoint");
//        modelAndView.addObject("settlementPoint", new SettlementPoint());
//        return modelAndView;
//    }

    @PostMapping(value = "/add")
    public SettlementPoint saveSettlementPoint(@RequestBody SettlementPoint settlementPoint) {
        settlementPoint.getOperation().setDate(new Date());
        return settlementPointService.save(settlementPoint);
    }


    // Изменение регистрационных параметров точки расчета
//    @RequestMapping(value = "/api/point/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = "application/json")
//    public String updateSettlementPoint(@RequestBody @Validated SettlementPoint settlementPoint) {
//        HttpHeaders headers = new HttpHeaders();
////        if (settlementPoint == null) {
////            return new ResponseEntity<SettlementPoint>(HttpStatus.BAD_REQUEST);
////        }
//        this.settlementPointService.update(settlementPoint);
//        return new ResponseEntity<SettlementPoint>(settlementPoint, headers, HttpStatus.CREATED);
//    }

    @PutMapping("/update/{pointId}")
    public ResponseEntity<SettlementPoint> update(@PathVariable(value = "pointId") String pointId,
                                                  @RequestBody SettlementPoint settlementPointDetails, PointAddress pointAddressDetails, Operation operation) throws ResourceNotFoundException {
        SettlementPoint settlementPoint = settlementPointRepository.findById(pointId).orElseThrow(() -> new ResourceNotFoundException("SettlementPoint not found for this id :: " + pointId));
        settlementPoint.setClientTin(settlementPointDetails.getClientTin());
        settlementPoint.setClientName(settlementPointDetails.getClientName());
        settlementPoint.setActivity(settlementPointDetails.getActivity());
        settlementPoint.setObjectType(settlementPointDetails.getObjectType());
        settlementPoint.setPointType(settlementPointDetails.getPointType());
        settlementPoint.setPointFormat(settlementPointDetails.getPointFormat());
        settlementPoint.setEquipmentType(settlementPointDetails.getEquipmentType());
        settlementPoint.setEquipmentId(settlementPointDetails.getEquipmentId());
        PointAddress pointAddress = new PointAddress();
        pointAddress.setPostalCode(pointAddressDetails.getPostalCode());
        pointAddress.setCountry(pointAddressDetails.getCountry());
        pointAddress.setAdministrativeArea(pointAddressDetails.getAdministrativeArea());
        pointAddress.setLocality(pointAddressDetails.getLocality());
        pointAddress.setRoute(pointAddressDetails.getRoute());
        pointAddress.setStreetNumber(pointAddressDetails.getStreetNumber());
        pointAddress.setLocation(pointAddressDetails.getLocation());
//        settlementPoint.setPointId(settlementPointDetails.getPointId());
//        settlementPoint.setClientTin(settlementPointDetails.getClientTin());
//        settlementPoint.setClientName(settlementPointDetails.getClientName());
//        settlementPoint.setActivity(settlementPointDetails.getActivity());
//        settlementPoint.setObjectType(settlementPointDetails.getObjectType());
//        settlementPoint.setPointType(settlementPointDetails.getPointType());
//        settlementPoint.setPointFormat(settlementPointDetails.getPointFormat());
//        settlementPoint.setEquipmentType(settlementPointDetails.getEquipmentType());
//        settlementPoint.setEquipmentId(settlementPointDetails.getEquipmentId());
//        PointAddress pointAddress = new PointAddress();
//        pointAddress.setPostalCode(pointAddressDetails.getPostalCode());
//        pointAddress.setCountry(pointAddressDetails.getCountry());
//        pointAddress.setAdministrativeArea(pointAddressDetails.getAdministrativeArea());
//        pointAddress.setLocality(pointAddressDetails.getLocality());
//        pointAddress.setRoute(pointAddressDetails.getRoute());
//        pointAddress.setStreetNumber(pointAddressDetails.getStreetNumber());
//        pointAddress.setLocation(pointAddressDetails.getLocation());
//        Operation operation = new Operation();
//        operation.setDate(new Date());
        operationService.save(operation);
        pointAddressService.save(pointAddress);
        settlementPointService.save(settlementPoint);
        return ResponseEntity.ok().body(settlementPoint);
    }

    // Снятие с регистрации точки расчета
    @DeleteMapping("/delete/{pointId}")
    public ResponseEntity<String> deleteSettlementPoint(@PathVariable(value = "pointId") String pointId) {
        this.settlementPointRepository.deleteById(pointId);
        return ResponseEntity.ok().body(pointId);
    }

    @GetMapping("/list/{pointId}")
    public ResponseEntity<SettlementPoint> getAllSettlementPointsByID(@PathVariable(value = "pointId") String pointId) throws ResourceNotFoundException {
        SettlementPoint settlementPoint = settlementPointRepository.findById(pointId).orElseThrow(() -> new ResourceNotFoundException("SettlementPoint not found for this id :: " + pointId));
        return ResponseEntity.ok().body(settlementPoint);
    }

    @GetMapping("/list")
    public List<SettlementPoint> getAllSettlementPoints() {
        return settlementPointRepository.findAll();
    }
}

