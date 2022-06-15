package com.ertugrul.fleet.management.system.service.entityservice;

import com.ertugrul.fleet.management.system.entity.Vehicle;

public interface VehicleEntityService extends CrudEntityService<Vehicle, Long> {
    Vehicle findVehicleByLicencePlate(String licencePlate);
}
