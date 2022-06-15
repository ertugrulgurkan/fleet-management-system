package com.ertugrul.fleet.management.system.controller;

import com.ertugrul.fleet.management.system.dto.DeliveryPointDto;
import com.ertugrul.fleet.management.system.service.DeliveryPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/delivery-points")
@RequiredArgsConstructor
public class DeliveryPointController {
    private final DeliveryPointService deliveryPointService;

    @GetMapping("")
    public ResponseEntity<List<DeliveryPointDto>> findAllDeliveryPoints() {
        return ResponseEntity.ok(deliveryPointService.findAllDeliveryPoints());
    }

    @PostMapping
    public ResponseEntity<DeliveryPointDto> createDeliveryPoint(@Valid @RequestBody DeliveryPointDto deliveryPointDto) {
        return ResponseEntity.ok(deliveryPointService.createDeliveryPoint(deliveryPointDto));
    }
}
