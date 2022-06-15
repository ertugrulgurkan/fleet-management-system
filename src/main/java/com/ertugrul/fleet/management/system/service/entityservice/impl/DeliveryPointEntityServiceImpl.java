package com.ertugrul.fleet.management.system.service.entityservice.impl;

import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import com.ertugrul.fleet.management.system.repository.DeliveryPointRepository;
import com.ertugrul.fleet.management.system.service.entityservice.DeliveryPointEntityService;
import com.ertugrul.fleet.management.system.validation.EntityValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryPointEntityServiceImpl extends BaseEntityService<DeliveryPoint, DeliveryPointRepository<DeliveryPoint>> implements DeliveryPointEntityService<DeliveryPoint> {

    private final EntityValidationService<DeliveryPoint> deliveryPointEntityValidationService;

    public DeliveryPointEntityServiceImpl(DeliveryPointRepository<DeliveryPoint> deliveryPointRepository, EntityValidationService<DeliveryPoint> deliveryPointEntityValidationService) {
        super(deliveryPointRepository);
        this.deliveryPointEntityValidationService = deliveryPointEntityValidationService;
    }

    @Override
    public DeliveryPoint findDeliveryPointByType(DeliveryPointType deliveryPointType) {
        return deliveryPointEntityValidationService.validateEntity(getRepository().findDeliveryPointByType(deliveryPointType), "Delivery Point");
    }

    @Override
    public DeliveryPoint create(DeliveryPoint deliveryPoint) {
        Optional<DeliveryPoint> deliveryPointByBarcode = getRepository().findDeliveryPointByType(deliveryPoint.getType());
        deliveryPointEntityValidationService.isEmpty(deliveryPointByBarcode, "Delivery Point");
        return getRepository().save(deliveryPoint);
    }
}