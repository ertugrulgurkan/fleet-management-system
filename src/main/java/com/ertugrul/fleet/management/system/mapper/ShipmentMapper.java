package com.ertugrul.fleet.management.system.mapper;

import com.ertugrul.fleet.management.system.dto.PackDto;
import com.ertugrul.fleet.management.system.dto.BagDto;
import com.ertugrul.fleet.management.system.entity.Bag;
import com.ertugrul.fleet.management.system.entity.Pack;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShipmentMapper {
    ShipmentMapper INSTANCE = Mappers.getMapper(ShipmentMapper.class);

    Bag toBag(BagDto bagDto);

    @Mapping(target = "deliveryPointForUnloading", expression = "java(bag.getDeliveryPoint().getType().getValue())")
    BagDto toBagDto(Bag bag);

    @Mapping(target = "deliveryPointForUnloading", expression = "java(bag.getDeliveryPoint().getType().getValue())")
    List<BagDto> toAllBagDto(List<Bag> bagList);

    Pack toPack(PackDto packDto);

    @Mapping(target = "deliveryPointForUnloading", expression = "java(pack.getDeliveryPoint().getType().getValue())")
    PackDto toPackDto(Pack pack);

    @Mapping(target = "deliveryPointForUnloading", expression = "java(pack.getDeliveryPoint().getType().getValue())")
    List<PackDto> toAllPackDto(List<Pack> packs);


}
