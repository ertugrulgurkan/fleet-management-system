package com.ertugrul.fleet.management.system.service.impl;

import com.ertugrul.fleet.management.system.entity.Shipment;
import com.ertugrul.fleet.management.system.service.ShipmentService;
import com.ertugrul.fleet.management.system.service.entityservice.ShipmentEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentEntityService<Shipment> shipmentEntityService;

    @Override
    public List<Shipment> findAllShipments() {
        return shipmentEntityService.findAll();
    }

    @Override
    public List<Shipment> findShipmentsByBarcodeList(List<String> barcodeList) {
        List<Shipment> allShipments = findAllShipments();
        return allShipments
                .stream()
                .filter(shipment -> barcodeList.contains(shipment.getBarcode())).toList();
    }
}
