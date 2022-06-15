package com.ertugrul.fleet.management.system.service;

import com.ertugrul.fleet.management.system.dto.BagDto;
import com.ertugrul.fleet.management.system.entity.Bag;
import com.ertugrul.fleet.management.system.mapper.ShipmentMapper;
import com.ertugrul.fleet.management.system.service.entityservice.ShipmentEntityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static com.ertugrul.fleet.management.system.util.ObjectFactoryTest.getBag;
import static com.ertugrul.fleet.management.system.util.ObjectFactoryTest.getTwoBag;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class BagServiceTest {

    @MockBean
    ShipmentEntityService<Bag> bagEntityService;
    @MockBean
    DeliveryPointService deliveryPointService;

    @Autowired
    BagService bagService;

    @Test
    void createBag() {
        Bag expected = getBag();
        BagDto expectedDto = ShipmentMapper.INSTANCE.toBagDto(expected);
        when(deliveryPointService.findDeliveryPointByType(any())).thenReturn(expected.getDeliveryPoint());
        when(bagEntityService.create(any())).thenReturn(expected);
        BagDto actualDto = bagService.createBag(expectedDto);
        assertAll(
                () -> assertNotNull(actualDto),
                () -> assertEquals(expectedDto, actualDto)
        );
    }

    @Test
    void findAllBags() {
        List<Bag> expected = getTwoBag();
        when(bagEntityService.findAll()).thenReturn(expected);
        List<BagDto> bagDtoList = ShipmentMapper.INSTANCE.toAllBagDto(expected);
        List<BagDto> actual = bagService.findAllBags();

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(bagDtoList.size(), actual.size()),
                () -> assertEquals(bagDtoList, actual)
        );
    }

    @Test
    void findBagByBarcode() {
        Bag expected = getBag();
        when(bagEntityService.findShipmentByBarcode(anyString())).thenReturn(expected);
        Bag actual = bagService.findBagByBarcode(expected.getBarcode());
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual)
        );
    }


}