package com.example.sto.service;

import com.example.sto.model.PointAddress;

import java.util.List;

public interface PointAddressService {
    PointAddress save(PointAddress pointAddress);
    //update
    void update(PointAddress pointAddress);
    //delete
    void delete(PointAddress pointAddress);

    //list
    List<PointAddress> getAll();
}
