package com.ertugrul.fleet.management.system.service.entityservice.impl;

import com.ertugrul.fleet.management.system.repository.VehicleRepository;
import com.ertugrul.fleet.management.system.entity.Vehicle;
import com.ertugrul.fleet.management.system.service.entityservice.VehicleEntityService;
import com.ertugrul.fleet.management.system.validation.EntityValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleEntityServiceImpl extends BaseEntityService<Vehicle, VehicleRepository> implements VehicleEntityService {

    private final EntityValidationService<Vehicle> vehicleEntityValidationService;

    public VehicleEntityServiceImpl(VehicleRepository vehicleRepository, EntityValidationService<Vehicle> vehicleEntityValidationService) {
        super(vehicleRepository);
        this.vehicleEntityValidationService = vehicleEntityValidationService;
    }

    @Override
    public Vehicle findVehicleByLicencePlate(String licencePlate) {
        return vehicleEntityValidationService.validateEntity(getRepository().findVehicleByLicencePlate(licencePlate), "Vehicle");
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        Optional<Vehicle> vehicleByBarcode = getRepository().findVehicleByLicencePlate(vehicle.getLicencePlate());
        vehicleEntityValidationService.isEmpty(vehicleByBarcode, "Vehicle");
        return getRepository().save(vehicle);
    }
}