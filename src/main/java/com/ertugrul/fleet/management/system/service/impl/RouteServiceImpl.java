package com.ertugrul.fleet.management.system.service.impl;

import com.ertugrul.fleet.management.system.entity.Route;
import com.ertugrul.fleet.management.system.entity.Shipment;
import com.ertugrul.fleet.management.system.entity.Vehicle;
import com.ertugrul.fleet.management.system.enums.ShipmentStatus;
import com.ertugrul.fleet.management.system.service.RouteService;
import com.ertugrul.fleet.management.system.service.VehicleService;
import com.ertugrul.fleet.management.system.service.entityservice.RouteEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RouteServiceImpl implements RouteService {

    private final RouteEntityService routeEntityService;
    private final VehicleService vehicleService;

    @Override
    public void createRoute(List<Shipment> shipmentList, String licencePlate) {
        List<Shipment> shipments = filterShipments(shipmentList);
        Vehicle vehicle = vehicleService.findVehicleByLicencePlate(licencePlate);
        Route routeEntity = createRouteEntity(shipments, vehicle);
        Route savedRoute = routeEntityService.save(routeEntity);
        shipments.forEach(shipment -> shipment.setRoute(savedRoute));
        log.info("Route is created. Route Id: " + savedRoute.getId());
    }

    private List<Shipment> filterShipments(List<Shipment> shipmentList) {
        return shipmentList.stream().filter(shipment ->
                shipment.getShipmentStatus().equals(ShipmentStatus.LOADED) ||
                        shipment.getShipmentStatus().equals(ShipmentStatus.UNLOADED)).toList();
    }

    private Route createRouteEntity(List<Shipment> shipments, Vehicle vehicle) {
        Route route = new Route();
        route.setVehicle(vehicle);
        route.setShipmentList(shipments);
        return route;
    }

}
