package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.dto.PackBagDto;
import com.ertugrul.fleet.management.system.dto.PackDto;
import com.ertugrul.fleet.management.system.entity.Pack;

import java.util.List;

public interface PackService {
    PackDto createPack(PackDto packDto);

    List<PackDto> findAllPacks();

    PackBagDto assignToBag(PackBagDto packBagDto);

    Pack findPackByBarcode(String barcode);
}
