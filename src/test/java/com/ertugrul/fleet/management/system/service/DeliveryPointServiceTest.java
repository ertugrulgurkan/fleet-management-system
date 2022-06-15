package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.dto.DeliveryPointDto;
import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.entity.Shipment;
import com.ertugrul.fleet.management.system.mapper.DeliveryPointMapper;
import com.ertugrul.fleet.management.system.service.entityservice.DeliveryPointEntityService;
import com.ertugrul.fleet.management.system.service.impl.DeliveryPointServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.ertugrul.fleet.management.system.util.ObjectFactoryTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeliveryPointServiceTest {

    @Mock
    ShipmentService shipmentService;
    @Mock
    DeliveryPointEntityService<DeliveryPoint> deliveryPointEntityService;

    @InjectMocks
    DeliveryPointServiceImpl deliveryPointService;

    @Test
    void createDeliveryPoint() {
        DeliveryPoint expected = getDeliveryPoint();
        DeliveryPointDto expectedDto = DeliveryPointMapper.INSTANCE.toDeliveryPointDto(expected);
        when(deliveryPointEntityService.create(any())).thenReturn(expected);
        DeliveryPointDto actualDto = deliveryPointService.createDeliveryPoint(expectedDto);
        assertAll(
                () -> assertNotNull(actualDto),
                () -> assertEquals(expectedDto, actualDto)
        );
    }

    @Test
    void saveDeliveryPoint() {
        DeliveryPoint expected = getDeliveryPoint();
        when(deliveryPointEntityService.save(any())).thenReturn(expected);
        DeliveryPoint actual = deliveryPointService.saveDeliveryPoint(expected);
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual)
        );
    }

    @Test
    void findAllDeliveryPoints() {
        List<DeliveryPoint> expectedList = getAllDeliveryPoints();
        when(deliveryPointEntityService.findAll()).thenReturn(expectedList);
        List<DeliveryPointDto> expected = DeliveryPointMapper.INSTANCE.toAllDeliveryPointDto(expectedList);

        List<DeliveryPointDto> actual = deliveryPointService.findAllDeliveryPoints();

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected.size(), actual.size()),
                () -> assertEquals(expected, actual)
        );
    }

    @Test
    void getDeliveryPointByType() {
        DeliveryPoint expected = getDeliveryPoint();
        when(deliveryPointEntityService.findDeliveryPointByType(any())).thenReturn(expected);
        DeliveryPoint actual = deliveryPointService.findDeliveryPointByType(expected.getType());
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual)
        );
    }

    @Test
    void unloadShipments() {
        List<Shipment> sixShipment = getSixShipment();
        List<DeliveryPoint> allDeliveryPoints = getAllDeliveryPoints();
        for (DeliveryPoint deliveryPoint : allDeliveryPoints) {
            deliveryPointService.unloadShipments(sixShipment, deliveryPoint);
        }
    }

    @Test
    void setShipmentsToDeliveryPoint() {
        DeliveryPoint deliveryPoint = getDeliveryPoint();
        List<Shipment> shipments = getSixShipment();
        shipments = shipments.stream().filter(shipment -> shipment.getDeliveryPoint().getType().equals(deliveryPoint.getType())).toList();
        List<String> deliveryBarcodes = shipments.stream().map(Shipment::getBarcode).toList();
        when(deliveryPointEntityService.findDeliveryPointByType(any())).thenReturn(deliveryPoint);
        when(shipmentService.findShipmentsByBarcodeList(any())).thenReturn(shipments);
        when(deliveryPointEntityService.save(any())).thenReturn(deliveryPoint);
        deliveryPointService.setShipmentsToDeliveryPoint(deliveryPoint.getType(), deliveryBarcodes);
    }

}