package com.ertugrul.fleet.management.system.repository;

import com.ertugrul.fleet.management.system.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;


@NoRepositoryBean
public interface BaseShipmentRepository<T extends Shipment> extends JpaRepository<T, Long> {
    Optional<T> findShipmentByBarcode(String barcode);
}

