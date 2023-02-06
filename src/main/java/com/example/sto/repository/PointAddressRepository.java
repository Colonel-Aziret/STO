package com.example.sto.repository;

import com.example.sto.model.PointAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointAddressRepository extends JpaRepository<PointAddress, Integer> {
}
