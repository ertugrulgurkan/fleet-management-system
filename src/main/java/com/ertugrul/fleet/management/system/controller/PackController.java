package com.ertugrul.fleet.management.system.controller;


import com.ertugrul.fleet.management.system.dto.PackBagDto;
import com.ertugrul.fleet.management.system.dto.PackDto;
import com.ertugrul.fleet.management.system.service.PackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/packs")
@RequiredArgsConstructor
public class PackController {
    private final PackService packService;

    @GetMapping("")
    public ResponseEntity<List<PackDto>> findAllPacks() {
        return ResponseEntity.ok(packService.findAllPacks());
    }

    @PostMapping
    public ResponseEntity<PackDto> createPack(@Valid @RequestBody PackDto packDto) {
        return ResponseEntity.ok(packService.createPack(packDto));
    }

    @PostMapping("/bag")
    public ResponseEntity<Object> assignToBag(@Valid @RequestBody PackBagDto packBagDto) {
        return ResponseEntity.ok(packService.assignToBag(packBagDto));
    }
}
