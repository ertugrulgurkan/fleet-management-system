package com.ertugrul.fleet.management.system.controller;


import com.ertugrul.fleet.management.system.dto.BagDto;
import com.ertugrul.fleet.management.system.service.BagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/bags")
@RequiredArgsConstructor
public class BagController {
    private final BagService bagService;

    @GetMapping("")
    public ResponseEntity<Object> findAllBags() {
        return ResponseEntity.ok(bagService.findAllBags());
    }

    @PostMapping
    public ResponseEntity<Object> createBag(@Valid @RequestBody BagDto bagDto) {
        return ResponseEntity.ok(bagService.createBag(bagDto));
    }
}
