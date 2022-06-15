package com.ertugrul.fleet.management.system.mapper;

import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import com.ertugrul.fleet.management.system.dto.DeliveryPointDto;
import com.ertugrul.fleet.management.system.factory.DeliveryPointFactory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeliveryPointMapper {
    DeliveryPointMapper INSTANCE = Mappers.getMapper(DeliveryPointMapper.class);

    DeliveryPoint toDeliveryPoint(DeliveryPointDto deliveryPointDto);

    @Mapping(target = "deliveryPointType", expression = "java(deliveryPoint.getType().getValue())")
    DeliveryPointDto toDeliveryPointDto(DeliveryPoint deliveryPoint);

    @Mapping(target = "deliveryPointType", expression = "java(deliveryPoint.getType().getValue())")
    List<DeliveryPointDto> toAllDeliveryPointDto(List<DeliveryPoint> deliveryPointList);

    @ObjectFactory
    default DeliveryPoint createDeliveryPoint(DeliveryPointDto deliveryPointDto) {
        DeliveryPointFactory deliveryPointFactory = new DeliveryPointFactory();
        return deliveryPointFactory.getDeliveryPoint(DeliveryPointType.getByInteger(deliveryPointDto.getDeliveryPointType()));
    }
}
