package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.dto.DeliveryPointDto;
import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.entity.Shipment;
import com.ertugrul.fleet.management.system.enums.DeliveryPointType;

import java.util.List;

public interface DeliveryPointService {
    DeliveryPointDto createDeliveryPoint(DeliveryPointDto deliveryPointDto);

    DeliveryPoint saveDeliveryPoint(DeliveryPoint deliveryPoint);

    List<DeliveryPointDto> findAllDeliveryPoints();

    DeliveryPoint findDeliveryPointByType(DeliveryPointType type);

    DeliveryPoint unloadShipments(List<Shipment> shipments, DeliveryPoint deliveryPoint);

    DeliveryPoint setShipmentsToDeliveryPoint(DeliveryPointType deliveryPointType, List<String> shipmentBarcodes);
}
