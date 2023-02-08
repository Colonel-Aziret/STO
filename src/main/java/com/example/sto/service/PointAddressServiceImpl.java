package com.example.sto.service;

import com.example.sto.model.PointAddress;
import com.example.sto.repository.PointAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointAddressServiceImpl implements PointAddressService {

    @Autowired
    PointAddressRepository pointAddressRepository;

    @Override
    public PointAddress save(PointAddress pointAddress) {
        pointAddressRepository.save(pointAddress);
        return pointAddress;
    }

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
