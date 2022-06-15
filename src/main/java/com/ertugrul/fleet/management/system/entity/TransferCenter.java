package com.ertugrul.fleet.management.system.entity;

import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import com.ertugrul.fleet.management.system.enums.ShipmentStatus;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TRANSFER_CENTER")
@Slf4j
public class TransferCenter extends DeliveryPoint {

    public TransferCenter() {
        super.type = DeliveryPointType.TRANSFER_CENTER;
    }


    @Override
    public void unloadBag(Bag bag) {
        bag.setShipmentStatus(ShipmentStatus.UNLOADED);
        bag.getPackList().forEach(s -> s.setShipmentStatus(ShipmentStatus.UNLOADED));
    }

    @Override
    public void unloadPack(Pack pack) {
        if (pack.getBag() != null) {
            pack.getBag().getPackList().forEach(s -> s.setShipmentStatus(ShipmentStatus.UNLOADED));
            pack.getBag().setShipmentStatus(ShipmentStatus.UNLOADED);

        } else {
            log.warn("Transfer Center: Only bags and packages in bags may be unloaded. Barcode number: " + pack.getBarcode());
            pack.setShipmentStatus(ShipmentStatus.LOADED);
        }
    }
}