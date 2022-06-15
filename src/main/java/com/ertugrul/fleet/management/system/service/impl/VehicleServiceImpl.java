package com.ertugrul.fleet.management.system.service.impl;

import com.ertugrul.fleet.management.system.dto.VehicleDto;
import com.ertugrul.fleet.management.system.entity.Vehicle;
import com.ertugrul.fleet.management.system.mapper.VehicleMapper;
import com.ertugrul.fleet.management.system.service.VehicleService;
import com.ertugrul.fleet.management.system.service.entityservice.VehicleEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    private final VehicleEntityService vehicleEntityService;

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = VehicleMapper.INSTANCE.toVehicle(vehicleDto);
        Vehicle savedVehicle = vehicleEntityService.create(vehicle);
        VehicleDto savedVehicleDto = VehicleMapper.INSTANCE.toVehicleDto(savedVehicle);
        log.info("Vehicle is saved: " + savedVehicleDto.toString());
        return savedVehicleDto;
    }

    @Override
    public List<VehicleDto> findAllVehicles() {
        List<Vehicle> vehicleList = vehicleEntityService.findAll();
        return VehicleMapper.INSTANCE.toAllVehicleDto(vehicleList);
    }

    @Override
    public Vehicle findVehicleByLicencePlate(String licencePlate) {
        return vehicleEntityService.findVehicleByLicencePlate(licencePlate);
    }
}
