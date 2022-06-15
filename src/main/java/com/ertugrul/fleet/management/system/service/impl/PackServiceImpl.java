package com.ertugrul.fleet.management.system.service.impl;

import com.ertugrul.fleet.management.system.dto.PackDto;
import com.ertugrul.fleet.management.system.service.PackService;
import com.ertugrul.fleet.management.system.dto.PackBagDto;
import com.ertugrul.fleet.management.system.entity.Bag;
import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.entity.Pack;
import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import com.ertugrul.fleet.management.system.enums.ShipmentStatus;
import com.ertugrul.fleet.management.system.exception.AlreadyExistException;
import com.ertugrul.fleet.management.system.mapper.ShipmentMapper;
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
public class PackServiceImpl implements PackService {

    private final ShipmentEntityService<Pack> packEntityService;
    private final DeliveryPointService deliveryPointService;
    private final BagService bagService;
    private final ShipmentMapper mapper = ShipmentMapper.INSTANCE;

    @Override
    public PackDto createPack(PackDto packDto) {
        Pack pack = mapper.toPack(packDto);
        DeliveryPoint deliveryPoint = deliveryPointService.findDeliveryPointByType(DeliveryPointType.getByInteger(packDto.getDeliveryPointForUnloading()));
        pack.setDeliveryPoint(deliveryPoint);
        Pack savedPack = packEntityService.create(pack);
        PackDto savedPackDto = mapper.toPackDto(savedPack);
        log.info("Pack is created: " + savedPackDto.toString());
        return savedPackDto;
    }

    @Override
    public List<PackDto> findAllPacks() {
        List<Pack> packList = packEntityService.findAll();
        return ShipmentMapper.INSTANCE.toAllPackDto(packList);
    }

    @Override
    public PackBagDto assignToBag(PackBagDto packBagDto) {
        Pack pack = findPackByBarcode(packBagDto.getBarcode());
        Bag bag = bagService.findBagByBarcode(packBagDto.getBagBarcode());
        if (pack.getBag() != null)
            throw new AlreadyExistException("The pack is already assigned into a bag. Package barcode : " + pack.getBarcode());
        pack.setShipmentStatus(ShipmentStatus.LOADED_INTO_BAG);
        pack.setBag(bag);
        packEntityService.save(pack);
        log.info("Pack is assigned into bag: " + packBagDto);
        return packBagDto;
    }

    @Override
    public Pack findPackByBarcode(String barcode) {
        return packEntityService.findShipmentByBarcode(barcode);
    }

}
