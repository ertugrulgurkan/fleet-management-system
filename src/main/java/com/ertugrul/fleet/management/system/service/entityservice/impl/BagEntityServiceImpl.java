package com.ertugrul.fleet.management.system.service.entityservice.impl;

import com.ertugrul.fleet.management.system.entity.Bag;
import com.ertugrul.fleet.management.system.repository.BagRepository;
import com.ertugrul.fleet.management.system.service.entityservice.ShipmentEntityService;
import com.ertugrul.fleet.management.system.validation.EntityValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BagEntityServiceImpl extends BaseEntityService<Bag, BagRepository> implements ShipmentEntityService<Bag> {
    private final EntityValidationService<Bag> bagEntityValidationService;

    public BagEntityServiceImpl(BagRepository bagRepository, EntityValidationService<Bag> bagEntityValidationService) {
        super(bagRepository);
        this.bagEntityValidationService = bagEntityValidationService;
    }

    @Override
    public Bag findShipmentByBarcode(String barcode) {
        Optional<Bag> shipmentByBarcode = getRepository().findShipmentByBarcode(barcode);
        return bagEntityValidationService.validateEntity(shipmentByBarcode, "Bag");
    }

    @Override
    public Bag create(Bag bag) {
        Optional<Bag> shipmentByBarcode = getRepository().findShipmentByBarcode(bag.getBarcode());
        bagEntityValidationService.isEmpty(shipmentByBarcode, "Bag");
        return getRepository().save(bag);
    }
}