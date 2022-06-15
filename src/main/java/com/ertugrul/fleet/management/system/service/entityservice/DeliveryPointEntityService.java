package com.ertugrul.fleet.management.system.service.entityservice;

import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.enums.DeliveryPointType;

public interface DeliveryPointEntityService<T extends DeliveryPoint> extends CrudEntityService<T, Long> {
    DeliveryPoint findDeliveryPointByType(DeliveryPointType deliveryPointType);
}
