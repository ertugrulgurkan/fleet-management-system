package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.entity.Shipment;
import com.ertugrul.fleet.management.system.dto.DeliveryDto;
import com.ertugrul.fleet.management.system.service.impl.DeliveryServiceImpl;
import com.ertugrul.fleet.management.system.util.ObjectFactoryTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.ertugrul.fleet.management.system.util.ObjectFactoryTest.getDeliveryDto;
import static com.ertugrul.fleet.management.system.util.ObjectFactoryTest.getTwoShipment;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeliveryServiceTest {

    @Mock
    DeliveryPointService deliveryPointService;
    @Mock
    RouteService routeService;

    @InjectMocks
    DeliveryServiceImpl deliveryService;


    @Test
    void makeDeliveries() {
        DeliveryDto expected = getDeliveryDto();
        DeliveryPoint deliveryPoint = ObjectFactoryTest.getDeliveryPoint();
        List<Shipment> twoShipment = getTwoShipment();
        twoShipment.get(0).setDeliveryPoint(deliveryPoint);
        twoShipment.get(1).setDeliveryPoint(deliveryPoint);
        deliveryPoint.setDeliveries(twoShipment);

        when(deliveryPointService.setShipmentsToDeliveryPoint(any(), anyList())).thenReturn(deliveryPoint);

        DeliveryDto actual = deliveryService.makeDeliveries(expected);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected.getPlate(), actual.getPlate()),
                () -> assertEquals(expected.getRoute().size(), actual.getRoute().size())
        );

    }

}