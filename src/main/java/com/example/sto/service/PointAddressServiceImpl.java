package com.example.sto.service;

import com.example.sto.dto.PointAddressDTO;
import com.example.sto.model.Operation;
import com.example.sto.model.PointAddress;
import com.example.sto.repository.OperationRepository;
import com.example.sto.repository.PointAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PointAddressServiceImpl implements PointAddressService {

    @Autowired
    PointAddressRepository pointAddressRepository;
    @Autowired
    OperationRepository operationRepository;

    @Override
    public PointAddress save(PointAddressDTO pointAddressDTO) {
        return pointAddressRepository.save(PointAddress.builder()
                .postalCode(pointAddressDTO.getPostalCode())
                .country(pointAddressDTO.getCountry())
                .administrativeArea(pointAddressDTO.getAdministrativeArea())
                .locality(pointAddressDTO.getLocality())
                .route(pointAddressDTO.getRoute())
                .streetNumber(pointAddressDTO.getStreetNumber())
                .location(pointAddressDTO.getLocation()).build());
    }

//    @Override
//    public PointAddress save(PointAddress pointAddress) {
//        return null;
//    }

    @Override
    public void update(PointAddress pointAddress) {
        pointAddressRepository.save(pointAddress);
    }

    @Override
    public void delete(PointAddress pointAddress) {
        pointAddressRepository.delete(pointAddress);
    }

    @Override
    public List<PointAddress> getAll() {
        return pointAddressRepository.findAll();
    }
}
