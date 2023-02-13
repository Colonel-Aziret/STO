package com.example.sto.controller;

import com.example.sto.model.PointAddress;
import com.example.sto.model.SettlementPoint;
import com.example.sto.repository.PointAddressRepository;
import com.example.sto.repository.SettlementPointRepository;
import com.example.sto.service.PointAddressService;
import com.example.sto.service.SettlementPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    // Регистрация точки расчета
//    @RequestMapping(value = "/api/point/add", method = RequestMethod.GET)
//    public ModelAndView addSettlementPoint() {
//        ModelAndView modelAndView = new ModelAndView("addSettlementPoint");
//        modelAndView.addObject("settlementPoint", new SettlementPoint());
//        return modelAndView;
//    }

    @PostMapping(value = "/add")
    public SettlementPoint saveSettlementPoint(@RequestBody SettlementPoint settlementPoint, PointAddress pointAddress) {
        pointAddressService.save(pointAddress);
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

    @PatchMapping("/update/{pointId}")
    public ResponseEntity<SettlementPoint> update(@PathVariable(value = "pointId") String pointId,
                                                  @RequestBody SettlementPoint settlementPointDetails, PointAddress pointAddress) {
        SettlementPoint settlementPoint = settlementPointRepository.findById(pointId).orElseThrow(() -> new ResourceNotFoundException("SettlementPoint not found for this id :: " + pointId));
        settlementPoint.setPointId(settlementPointDetails.getPointId());
        settlementPoint.setActivity(settlementPointDetails.getActivity());
        settlementPoint.setObjectType(settlementPointDetails.getObjectType());
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

