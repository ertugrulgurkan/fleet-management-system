package com.ertugrul.fleet.management.system.service.entityservice.impl;

import com.ertugrul.fleet.management.system.entity.Pack;
import com.ertugrul.fleet.management.system.repository.PackRepository;
import com.ertugrul.fleet.management.system.service.entityservice.ShipmentEntityService;
import com.ertugrul.fleet.management.system.validation.EntityValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PackEntityServiceImpl extends BaseEntityService<Pack, PackRepository> implements ShipmentEntityService<Pack> {
    private final EntityValidationService<Pack> packEntityValidationService;

    public PackEntityServiceImpl(PackRepository packRepository, EntityValidationService<Pack> packEntityValidationService) {
        super(packRepository);
        this.packEntityValidationService = packEntityValidationService;
    }

    @Override
    public Pack findShipmentByBarcode(String barcode) {
        return packEntityValidationService.validateEntity(getRepository().findShipmentByBarcode(barcode), "Pack");
    }

    @Override
    public Pack create(Pack pack) {
        Optional<Pack> shipmentByBarcode = getRepository().findShipmentByBarcode(pack.getBarcode());
        packEntityValidationService.isEmpty(shipmentByBarcode, "Pack");
        return getRepository().save(pack);
    }
}