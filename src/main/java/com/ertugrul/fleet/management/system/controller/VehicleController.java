package com.ertugrul.fleet.management.system.controller;


import com.ertugrul.fleet.management.system.dto.VehicleDto;
import com.ertugrul.fleet.management.system.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping("")
    public ResponseEntity<Object> findAllVehicles() {
        return ResponseEntity.ok(vehicleService.findAllVehicles());
    }

    @PostMapping
    public ResponseEntity<Object> createVehicle(@Valid @RequestBody VehicleDto vehicleDto) {
        return ResponseEntity.ok(vehicleService.createVehicle(vehicleDto));
    }
}
