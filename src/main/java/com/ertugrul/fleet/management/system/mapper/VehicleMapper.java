package com.ertugrul.fleet.management.system.mapper;

import com.ertugrul.fleet.management.system.dto.VehicleDto;
import com.ertugrul.fleet.management.system.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleMapper {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    Vehicle toVehicle(VehicleDto vehicleDto);

    VehicleDto toVehicleDto(Vehicle vehicle);

    List<VehicleDto> toAllVehicleDto(List<Vehicle> vehicleList);

}
