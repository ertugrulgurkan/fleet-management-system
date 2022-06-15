package com.ertugrul.fleet.management.system.entity;

import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import com.ertugrul.fleet.management.system.enums.ShipmentStatus;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BRANCH")
@Slf4j
public class Branch extends DeliveryPoint {
    public Branch() {
        super.type = DeliveryPointType.BRANCH;
    }

    @Override
    public void unloadBag(Bag bag) {
        log.warn("Branch: Only package-type shipments can be unloaded. Barcode number: " + bag.getBarcode());
    }

    @Override
    public void unloadPack(Pack pack) {
        if (pack.getBag() != null) {
            log.warn("Branch: Packages in bags can not be unloaded. Barcode number: " + pack.getBarcode());
        } else {
            pack.setShipmentStatus(ShipmentStatus.UNLOADED);
        }

    }
}