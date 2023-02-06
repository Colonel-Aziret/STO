package com.example.sto.repository;

import com.example.sto.model.SettlementPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SettlementPointRepository extends JpaRepository<SettlementPoint, UUID> {
}
