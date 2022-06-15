package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.entity.Bag;
import com.ertugrul.fleet.management.system.dto.BagDto;

import java.util.List;

public interface BagService {
    BagDto createBag(BagDto bagDto);

    List<BagDto> findAllBags();

    Bag findBagByBarcode(String barcode);
}
