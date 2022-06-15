package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.dto.VehicleDto;
import com.ertugrul.fleet.management.system.entity.Vehicle;
import com.ertugrul.fleet.management.system.mapper.VehicleMapper;
import com.ertugrul.fleet.management.system.service.entityservice.VehicleEntityService;
import com.ertugrul.fleet.management.system.service.impl.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.ertugrul.fleet.management.system.util.ObjectFactoryTest.getTwoVehicle;
import static com.ertugrul.fleet.management.system.util.ObjectFactoryTest.getVehicle;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    VehicleEntityService vehicleEntityService;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createVehicle() {
        Vehicle expected = getVehicle();
        when(vehicleEntityService.create(any())).thenReturn(expected);
        VehicleDto expectedDto = VehicleMapper.INSTANCE.toVehicleDto(expected);
        VehicleDto actualDto = vehicleService.createVehicle(expectedDto);
        assertAll(
                () -> assertNotNull(actualDto),
                () -> assertEquals(expectedDto, actualDto)
        );
    }

    @Test
    void findAllVehicles() {
        List<Vehicle> expected = getTwoVehicle();

        when(vehicleEntityService.findAll()).thenReturn(expected);

        List<VehicleDto> vehicleDtoList = VehicleMapper.INSTANCE.toAllVehicleDto(expected);

        List<VehicleDto> actual = vehicleService.findAllVehicles();

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(vehicleDtoList.size(), actual.size()),
                () -> assertEquals(vehicleDtoList, actual)
        );
    }

    @Test
    void findVehicleByLicencePlate() {
        Vehicle expected = getVehicle();
        when(vehicleEntityService.findVehicleByLicencePlate(anyString())).thenReturn(expected);
        Vehicle actual = vehicleService.findVehicleByLicencePlate(anyString());
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual)
        );
    }


}