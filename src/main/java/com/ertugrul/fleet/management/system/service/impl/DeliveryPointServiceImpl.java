package com.ertugrul.fleet.management.system.service.impl;

import com.ertugrul.fleet.management.system.dto.DeliveryPointDto;
import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.entity.Shipment;
import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import com.ertugrul.fleet.management.system.mapper.DeliveryPointMapper;
import com.ertugrul.fleet.management.system.service.entityservice.DeliveryPointEntityService;
import com.ertugrul.fleet.management.system.service.DeliveryPointService;
import com.ertugrul.fleet.management.system.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryPointServiceImpl implements DeliveryPointService {

    private final DeliveryPointEntityService<DeliveryPoint> deliveryPointEntityService;
    private final ShipmentService shipmentService;
    private final DeliveryPointMapper mapper = DeliveryPointMapper.INSTANCE;


    @Override
    public DeliveryPointDto createDeliveryPoint(DeliveryPointDto deliveryPointDto) {
        DeliveryPoint deliveryPoint = mapper.toDeliveryPoint(deliveryPointDto);
        DeliveryPoint savedDeliveryPoint = deliveryPointEntityService.create(deliveryPoint);
        DeliveryPointDto savedDeliveryPointDto = mapper.toDeliveryPointDto(savedDeliveryPoint);
        log.info("DeliveryPoint is saved: " + savedDeliveryPointDto.toString());
        return savedDeliveryPointDto;
    }

    @Override
    public DeliveryPoint saveDeliveryPoint(DeliveryPoint deliveryPoint) {
        return deliveryPointEntityService.save(deliveryPoint);
    }

    @Override
    public List<DeliveryPointDto> findAllDeliveryPoints() {
        List<DeliveryPoint> deliveryPointList = deliveryPointEntityService.findAll();
        return mapper.toAllDeliveryPointDto(deliveryPointList);
    }

    @Override
    public DeliveryPoint findDeliveryPointByType(DeliveryPointType type) {
        return deliveryPointEntityService.findDeliveryPointByType(type);
    }

    @Override
    public DeliveryPoint unloadShipments(List<Shipment> shipments, DeliveryPoint deliveryPoint) {
        for (Shipment shipment : shipments) {
            shipment.setShipmentToUnload(deliveryPoint);
        }
        return deliveryPoint;
    }

    @Override
    public DeliveryPoint setShipmentsToDeliveryPoint(DeliveryPointType deliveryPointType, List<String> deliveryBarcodes) {
        DeliveryPoint deliveryPoint = findDeliveryPointByType(deliveryPointType);
        List<Shipment> shipments = shipmentService.findShipmentsByBarcodeList(deliveryBarcodes);
        deliveryPoint = unloadShipments(shipments, deliveryPoint);
        return saveDeliveryPoint(deliveryPoint);
    }
}
