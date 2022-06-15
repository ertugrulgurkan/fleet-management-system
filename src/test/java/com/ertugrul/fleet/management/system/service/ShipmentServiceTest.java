package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.entity.Shipment;
import com.ertugrul.fleet.management.system.service.entityservice.ShipmentEntityService;
import com.ertugrul.fleet.management.system.service.impl.ShipmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.ertugrul.fleet.management.system.util.ObjectFactoryTest.getTwoShipment;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShipmentServiceTest {


    @Mock
    ShipmentEntityService<Shipment> shipmentEntityService;

    @InjectMocks
    ShipmentServiceImpl shipmentService;


    @Test
    void findAllShipments() {
        List<Shipment> expected = getTwoShipment();
        when(shipmentEntityService.findAll()).thenReturn(expected);
        List<Shipment> actual = shipmentService.findAllShipments();
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected.size(), actual.size()),
                () -> assertEquals(expected, actual)
        );
    }

    @Test
    void findShipmentsByBarcodeList() {

        List<Shipment> expected = getTwoShipment();

        List<String> barcodeList = expected.stream().map(Shipment::getBarcode).toList();

        when(shipmentEntityService.findAll()).thenReturn(expected);
        List<Shipment> actual = shipmentService.findShipmentsByBarcodeList(barcodeList);
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual)
        );
    }
}