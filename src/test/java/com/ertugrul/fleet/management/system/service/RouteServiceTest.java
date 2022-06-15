package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.entity.Route;
import com.ertugrul.fleet.management.system.entity.Shipment;
import com.ertugrul.fleet.management.system.entity.Vehicle;
import com.ertugrul.fleet.management.system.service.entityservice.RouteEntityService;
import com.ertugrul.fleet.management.system.service.impl.RouteServiceImpl;
import com.ertugrul.fleet.management.system.util.ObjectFactoryTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RouteServiceTest {

    @Mock
    VehicleService vehicleService;
    @Mock
    RouteEntityService routeEntityService;

    @InjectMocks
    RouteServiceImpl routeService;

    @Test
    void createRoute() {
        List<Shipment> twoLoadedShipment = ObjectFactoryTest.getTwoLoadedShipment();
        Vehicle vehicle = ObjectFactoryTest.getVehicle();
        Route expected = new Route();
        expected.setId(1L);
        expected.setShipmentList(twoLoadedShipment);
        expected.setVehicle(vehicle);
        when(vehicleService.findVehicleByLicencePlate(anyString())).thenReturn(vehicle);
        when(routeEntityService.save(any())).thenReturn(expected);
        routeService.createRoute(twoLoadedShipment, vehicle.getLicencePlate());
    }


}