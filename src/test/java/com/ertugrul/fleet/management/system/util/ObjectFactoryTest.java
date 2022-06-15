package com.ertugrul.fleet.management.system.util;

import com.ertugrul.fleet.management.system.dto.*;
import com.ertugrul.fleet.management.system.entity.*;
import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import com.ertugrul.fleet.management.system.enums.ShipmentStatus;
import com.ertugrul.fleet.management.system.factory.DeliveryPointFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ObjectFactoryTest {

    public static Vehicle getVehicle() {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(1L);
        vehicle1.setLicencePlate("34 TL 34");
        return vehicle1;
    }

    public static List<Vehicle> getTwoVehicle() {
        List<Vehicle> vehicleList = new ArrayList<>();

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(1L);
        vehicle1.setLicencePlate("34 TL 34");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setId(2L);
        vehicle2.setLicencePlate("34 FB 34");

        vehicleList.add(vehicle1);
        vehicleList.add(vehicle2);

        return vehicleList;
    }

    public static List<Shipment> getTwoShipment() {
        List<Shipment> shipmentList = new ArrayList<>();

        Shipment shipment1 = new Bag();
        shipment1.setId(1L);
        shipment1.setShipmentStatus(ShipmentStatus.CREATED);
        shipment1.setBarcode("B00564");

        Shipment shipment2 = new Pack();
        shipment2.setId(2L);
        shipment2.setShipmentStatus(ShipmentStatus.CREATED);
        shipment2.setBarcode("P00560");

        shipmentList.add(shipment1);
        shipmentList.add(shipment2);

        return shipmentList;
    }

    public static List<Shipment> getSixShipment() {
        List<Shipment> shipmentList = new ArrayList<>();

        Shipment shipment1 = new Bag();
        shipment1.setId(1L);
        shipment1.setShipmentStatus(ShipmentStatus.CREATED);
        shipment1.setBarcode("B00564");
        shipment1.setDeliveryPoint(getAllDeliveryPoints().get(0));

        Shipment shipment2 = new Bag();
        shipment2.setId(2L);
        shipment2.setShipmentStatus(ShipmentStatus.CREATED);
        shipment2.setBarcode("B00561");
        shipment2.setDeliveryPoint(getAllDeliveryPoints().get(1));

        Shipment shipment3 = new Bag();
        shipment3.setId(3L);
        shipment3.setShipmentStatus(ShipmentStatus.CREATED);
        shipment3.setBarcode("B00562");
        shipment3.setDeliveryPoint(getAllDeliveryPoints().get(2));

        Shipment shipment4 = new Pack();
        shipment4.setId(4L);
        shipment4.setShipmentStatus(ShipmentStatus.CREATED);
        shipment4.setBarcode("P00560");
        shipment4.setDeliveryPoint(getAllDeliveryPoints().get(0));

        Shipment shipment5 = new Pack();
        shipment5.setId(5L);
        shipment5.setShipmentStatus(ShipmentStatus.CREATED);
        shipment5.setBarcode("P00561");
        shipment5.setDeliveryPoint(getAllDeliveryPoints().get(1));

        Shipment shipment6 = new Pack();
        shipment6.setId(6L);
        shipment6.setShipmentStatus(ShipmentStatus.CREATED);
        shipment6.setBarcode("P00562");
        shipment6.setDeliveryPoint(getAllDeliveryPoints().get(2));

        shipmentList.add(shipment1);
        shipmentList.add(shipment2);
        shipmentList.add(shipment3);
        shipmentList.add(shipment4);
        shipmentList.add(shipment5);
        shipmentList.add(shipment6);

        return shipmentList;
    }

    public static List<Shipment> getTwoLoadedShipment() {
        List<Shipment> shipmentList = new ArrayList<>();

        Shipment shipment1 = new Bag();
        shipment1.setId(1L);
        shipment1.setShipmentStatus(ShipmentStatus.LOADED);
        shipment1.setBarcode("B00564");

        Shipment shipment2 = new Pack();
        shipment2.setId(2L);
        shipment2.setShipmentStatus(ShipmentStatus.LOADED);
        shipment2.setBarcode("B00560");

        shipmentList.add(shipment1);
        shipmentList.add(shipment2);

        return shipmentList;
    }

    public static List<Pack> getTwoPack() {
        List<Pack> packList = new ArrayList<>();
        DeliveryPoint deliveryPoint = new Branch();

        Pack pack1 = new Pack();
        pack1.setId(1L);
        pack1.setShipmentStatus(ShipmentStatus.CREATED);
        pack1.setBarcode("B10258");
        pack1.setDeliveryPoint(deliveryPoint);


        Pack pack2 = new Pack();
        pack2.setId(2L);
        pack2.setShipmentStatus(ShipmentStatus.CREATED);
        pack2.setBarcode("B10257");
        pack2.setDeliveryPoint(deliveryPoint);

        packList.add(pack1);
        packList.add(pack2);

        return packList;
    }

    public static Pack getPack() {
        DeliveryPoint deliveryPoint = new Branch();
        Pack pack1 = new Pack();
        pack1.setId(1L);
        pack1.setShipmentStatus(ShipmentStatus.CREATED);
        pack1.setBarcode("B10258");
        pack1.setDeliveryPoint(deliveryPoint);
        return pack1;
    }

    public static Optional<Pack> getOptionalPack() {
        DeliveryPoint deliveryPoint = new Branch();
        Pack pack1 = new Pack();
        pack1.setId(1L);
        pack1.setShipmentStatus(ShipmentStatus.CREATED);
        pack1.setBarcode("B10258");
        pack1.setDeliveryPoint(deliveryPoint);
        return Optional.of(pack1);
    }

    public static Optional<Pack> getOptionalEmpty() {
        Optional<Pack> packOptional = Optional.empty();
        return packOptional;
    }

    public static DeliveryPoint getDeliveryPoint() {
        DeliveryPointFactory deliveryPointFactory = new DeliveryPointFactory();
        return deliveryPointFactory.getDeliveryPoint(DeliveryPointType.BRANCH);
    }

    public static List<DeliveryPoint> getAllDeliveryPoints() {
        DeliveryPointFactory deliveryPointFactory = new DeliveryPointFactory();
        List<DeliveryPoint> deliveryPointList = new ArrayList<>();
        deliveryPointList.add(deliveryPointFactory.getDeliveryPoint(DeliveryPointType.BRANCH));
        deliveryPointList.add(deliveryPointFactory.getDeliveryPoint(DeliveryPointType.TRANSFER_CENTER));
        deliveryPointList.add(deliveryPointFactory.getDeliveryPoint(DeliveryPointType.DISTRIBUTION_CENTER));
        return deliveryPointList;
    }

    public static PackBagDto getPackBagDto() {
        PackBagDto packBagDto = new PackBagDto();
        packBagDto.setBarcode("P10005");
        packBagDto.setBagBarcode("B10005");
        return packBagDto;
    }

    public static List<Bag> getTwoBag() {
        List<Bag> bagList = new ArrayList<>();
        DeliveryPoint deliveryPoint = new Branch();

        Bag bag1 = new Bag();
        bag1.setId(1L);
        bag1.setShipmentStatus(ShipmentStatus.CREATED);
        bag1.setBarcode("B10258");
        bag1.setDeliveryPoint(deliveryPoint);


        Bag bag2 = new Bag();
        bag2.setId(2L);
        bag2.setShipmentStatus(ShipmentStatus.CREATED);
        bag2.setBarcode("B10257");
        bag2.setDeliveryPoint(deliveryPoint);

        bagList.add(bag1);
        bagList.add(bag2);

        return bagList;
    }

    public static Bag getBag() {
        DeliveryPoint deliveryPoint = new Branch();
        Bag bag1 = new Bag();
        bag1.setId(1L);
        bag1.setShipmentStatus(ShipmentStatus.CREATED);
        bag1.setBarcode("B10258");
        bag1.setDeliveryPoint(deliveryPoint);
        return bag1;
    }

    public static BagDto getBagDto() {
        BagDto bag1 = new BagDto();
        bag1.setDeliveryPointForUnloading(1);
        bag1.setBarcode("B10258");
        return bag1;
    }

    public static DeliveryDto getDeliveryDto() {
        DeliveryDto deliveryDto = new DeliveryDto();
        RouteDto routeDto = new RouteDto();
        List<RouteDto> routeDtoList = new ArrayList<>();
        List<ShipmentDto> shipmentDtoList = new ArrayList<>();
        ShipmentDto shipmentDto1 = new ShipmentDto();
        shipmentDto1.setState(1);
        shipmentDto1.setBarcode("B00564");
        ShipmentDto shipmentDto2 = new ShipmentDto();
        shipmentDto2.setState(1);
        shipmentDto2.setBarcode("P00560");
        shipmentDtoList.add(shipmentDto1);
        shipmentDtoList.add(shipmentDto2);
        routeDto.setDeliveries(shipmentDtoList);
        routeDtoList.add(routeDto);
        deliveryDto.setRoute(routeDtoList);
        deliveryDto.setPlate("34 TL 34");
        return deliveryDto;
    }
}
