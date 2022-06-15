package com.ertugrul.fleet.management.system.service.impl;

import com.ertugrul.fleet.management.system.entity.Bag;
import com.ertugrul.fleet.management.system.mapper.ShipmentMapper;
import com.ertugrul.fleet.management.system.dto.BagDto;
import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import com.ertugrul.fleet.management.system.service.BagService;
import com.ertugrul.fleet.management.system.service.DeliveryPointService;
import com.ertugrul.fleet.management.system.service.entityservice.ShipmentEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BagServiceImpl implements BagService {

    private final ShipmentEntityService<Bag> bagEntityService;
    private final DeliveryPointService deliveryPointService;
    private final ShipmentMapper mapper = ShipmentMapper.INSTANCE;

    @Override
    public BagDto createBag(BagDto bagDto) {
        Bag bag = mapper.toBag(bagDto);
        DeliveryPoint deliveryPoint = deliveryPointService.findDeliveryPointByType(DeliveryPointType.getByInteger(bagDto.getDeliveryPointForUnloading()));
        bag.setDeliveryPoint(deliveryPoint);
        Bag savedBag = bagEntityService.create(bag);
        BagDto savedBagDto = mapper.toBagDto(savedBag);
        log.info("Bag is created: " + savedBagDto.toString());
        return savedBagDto;
    }

    @Override
    public List<BagDto> findAllBags() {
        List<Bag> bagList = bagEntityService.findAll();
        return ShipmentMapper.INSTANCE.toAllBagDto(bagList);
    }

    @Override
    public Bag findBagByBarcode(String barcode) {
        return bagEntityService.findShipmentByBarcode(barcode);
    }
}
