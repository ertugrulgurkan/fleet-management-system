package com.ertugrul.fleet.management.system.controller;


import com.ertugrul.fleet.management.system.dto.DeliveryDto;
import com.ertugrul.fleet.management.system.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/deliveries")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<DeliveryDto> makeDeliveries(@Valid @RequestBody DeliveryDto deliveryDto) {
        return ResponseEntity.ok(deliveryService.makeDeliveries(deliveryDto));
    }
}
