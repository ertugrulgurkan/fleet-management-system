package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.entity.Shipment;

import java.util.List;

public interface ShipmentService {
    List<Shipment> findAllShipments();

    List<Shipment> findShipmentsByBarcodeList(List<String> barcodeList);
}
