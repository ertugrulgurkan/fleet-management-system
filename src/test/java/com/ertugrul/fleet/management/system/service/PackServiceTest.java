package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.dto.PackDto;
import com.ertugrul.fleet.management.system.entity.Bag;
import com.ertugrul.fleet.management.system.entity.Pack;
import com.ertugrul.fleet.management.system.enums.ShipmentStatus;
import com.ertugrul.fleet.management.system.mapper.ShipmentMapper;
import com.ertugrul.fleet.management.system.service.impl.PackServiceImpl;
import com.ertugrul.fleet.management.system.dto.PackBagDto;
import com.ertugrul.fleet.management.system.exception.AlreadyExistException;
import com.ertugrul.fleet.management.system.service.entityservice.ShipmentEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.ertugrul.fleet.management.system.util.ObjectFactoryTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PackServiceTest {

    @Mock
    ShipmentEntityService<Pack> packEntityService;
    @Mock
    DeliveryPointService deliveryPointService;
    @Mock
    BagService bagService;

    @InjectMocks
    PackServiceImpl packService;

    @Test
    void createPack() {
        Pack expected = getPack();
        PackDto expectedDto = ShipmentMapper.INSTANCE.toPackDto(expected);
        when(deliveryPointService.findDeliveryPointByType(any())).thenReturn(expected.getDeliveryPoint());
        when(packEntityService.create(any())).thenReturn(expected);
        PackDto actualDto = packService.createPack(expectedDto);
        assertAll(
                () -> assertNotNull(actualDto),
                () -> assertEquals(expectedDto, actualDto)
        );
    }

    @Test
    void findAllPacks() {
        List<Pack> expected = getTwoPack();
        when(packEntityService.findAll()).thenReturn(expected);
        List<PackDto> packDtoList = ShipmentMapper.INSTANCE.toAllPackDto(expected);
        List<PackDto> actual = packService.findAllPacks();

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(packDtoList.size(), actual.size()),
                () -> assertEquals(packDtoList, actual)
        );
    }

    @Test
    void findPackByBarcode() {
        Pack expected = getPack();
        when(packEntityService.findShipmentByBarcode(anyString())).thenReturn(expected);
        Pack actual = packService.findPackByBarcode(expected.getBarcode());
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual)
        );
    }

    @Test
    void shouldAssignToPack() {
        PackBagDto expected = getPackBagDto();
        Pack pack = new Pack();
        pack.setBarcode(expected.getBarcode());
        Bag bag = new Bag();
        bag.setBarcode(expected.getBagBarcode());
        when(packEntityService.findShipmentByBarcode(anyString())).thenReturn(pack);
        when(bagService.findBagByBarcode(anyString())).thenReturn(bag);
        when(packEntityService.save(any())).thenReturn(pack);
        PackBagDto actual = packService.assignToBag(expected);
        pack.setBag(bag);
        pack.setShipmentStatus(ShipmentStatus.LOADED_INTO_BAG);
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected.getBagBarcode(), actual.getBagBarcode()),
                () -> assertEquals(expected.getBarcode(), actual.getBarcode())
        );
    }

    @Test
    void shouldNotAssignToPack() {
        PackBagDto expected = getPackBagDto();
        Pack pack = new Pack();
        pack.setBarcode(expected.getBarcode());
        Bag bag = new Bag();
        pack.setBag(bag);
        pack.setShipmentStatus(ShipmentStatus.LOADED_INTO_BAG);
        bag.setBarcode(expected.getBagBarcode());
        when(packEntityService.findShipmentByBarcode(anyString())).thenReturn(pack);
        when(bagService.findBagByBarcode(anyString())).thenReturn(bag);
        assertThrows(AlreadyExistException.class, () -> packService.assignToBag(expected));
    }
}