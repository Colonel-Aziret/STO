package com.example.sto.service;

import com.example.sto.model.PointAddress;

import java.util.List;
import java.util.UUID;

public interface PointAddressService {
    void save(PointAddress pointAddress);
    //update
    void update(PointAddress pointAddress);
    //delete
    void delete(PointAddress pointAddress);

    //list
    List<PointAddress> getAll();
}
