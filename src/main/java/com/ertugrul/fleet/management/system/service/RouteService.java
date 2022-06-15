package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.entity.Shipment;

import java.util.List;

public interface RouteService {
    void createRoute(List<Shipment> shipmentList, String licencePlate);
}
