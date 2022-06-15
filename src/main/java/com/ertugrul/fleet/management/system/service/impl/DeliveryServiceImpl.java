package com.ertugrul.fleet.management.system.service.impl;

import com.ertugrul.fleet.management.system.dto.ShipmentDto;
import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.entity.Shipment;
import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import com.ertugrul.fleet.management.system.service.DeliveryPointService;
import com.ertugrul.fleet.management.system.service.DeliveryService;
import com.ertugrul.fleet.management.system.dto.DeliveryDto;
import com.ertugrul.fleet.management.system.dto.RouteDto;
import com.ertugrul.fleet.management.system.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryPointService deliveryPointService;
    private final RouteService routeService;

    @Override
    @Transactional
    public DeliveryDto makeDeliveries(DeliveryDto deliveryDto) {
        List<RouteDto> routeDtoList = deliveryDto.getRoute();
        for (RouteDto routeDto : routeDtoList) {
            List<String> deliveryBarcodes = routeDto.getDeliveries().stream().map(ShipmentDto::getBarcode).toList();
            DeliveryPointType deliveryPointType = DeliveryPointType.getByInteger(routeDto.getDeliveryPoint());
            DeliveryPoint deliveryPoint = deliveryPointService.setShipmentsToDeliveryPoint(deliveryPointType, deliveryBarcodes);
            List<Shipment> shipments = deliveryPoint.getDeliveries().stream().toList();
            routeService.createRoute(shipments, deliveryDto.getPlate());
            setStateOfDeliveries(routeDto.getDeliveries(), deliveryPoint);
        }
        log.info("Deliveries were made: " + deliveryDto);
        return deliveryDto;
    }

    private void setStateOfDeliveries(List<ShipmentDto> deliveries, DeliveryPoint deliveryPoint) {
        List<Shipment> shipments = deliveryPoint.getDeliveries();
        for (Shipment shipment : shipments) {
            deliveries.stream()
                    .filter(shipmentDto -> shipmentDto.getBarcode().equals(shipment.getBarcode()))
                    .findAny().ifPresent(shipmentDto -> shipmentDto.setState(shipment.getShipmentStatus().getStatus()));
        }
    }
}
