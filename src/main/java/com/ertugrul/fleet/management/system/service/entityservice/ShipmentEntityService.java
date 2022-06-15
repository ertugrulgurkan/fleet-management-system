package com.ertugrul.fleet.management.system.service.entityservice;

import com.ertugrul.fleet.management.system.entity.Shipment;

public interface ShipmentEntityService<T extends Shipment> extends CrudEntityService<T, Long> {
    T findShipmentByBarcode(String barcode);
}
