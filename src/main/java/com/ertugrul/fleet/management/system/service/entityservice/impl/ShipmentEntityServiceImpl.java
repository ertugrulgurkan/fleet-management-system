package com.ertugrul.fleet.management.system.service.entityservice.impl;

import com.ertugrul.fleet.management.system.entity.Shipment;
import com.ertugrul.fleet.management.system.repository.ShipmentRepository;
import com.ertugrul.fleet.management.system.validation.EntityValidationService;
import com.ertugrul.fleet.management.system.service.entityservice.ShipmentEntityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipmentEntityServiceImpl extends BaseEntityService<Shipment, ShipmentRepository> implements ShipmentEntityService<Shipment> {
    private final EntityValidationService<Shipment> shipmentEntityValidationService;

    public ShipmentEntityServiceImpl(ShipmentRepository shipmentRepository, EntityValidationService<Shipment> shipmentEntityValidationService) {
        super(shipmentRepository);
        this.shipmentEntityValidationService = shipmentEntityValidationService;
    }

    @Override
    public Shipment findShipmentByBarcode(String barcode) {
        return shipmentEntityValidationService.validateEntity(getRepository().findShipmentByBarcode(barcode), "Shipment");
    }

    @Override
    public Shipment create(Shipment shipment) {
        Optional<Shipment> shipmentByBarcode = getRepository().findShipmentByBarcode(shipment.getBarcode());
        shipmentEntityValidationService.isEmpty(shipmentByBarcode, "Shipment");
        return getRepository().save(shipment);
    }
}