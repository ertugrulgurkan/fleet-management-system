package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.dto.VehicleDto;
import com.ertugrul.fleet.management.system.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    VehicleDto createVehicle(VehicleDto vehicleDto);

    List<VehicleDto> findAllVehicles();

    Vehicle findVehicleByLicencePlate(String licencePlate);
}
