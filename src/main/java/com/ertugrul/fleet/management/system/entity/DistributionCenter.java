package com.ertugrul.fleet.management.system.entity;

import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import com.ertugrul.fleet.management.system.enums.ShipmentStatus;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DISTRIBUTION_CENTER")
public class DistributionCenter extends DeliveryPoint {

    public DistributionCenter() {
        super.type = DeliveryPointType.DISTRIBUTION_CENTER;
    }

    @Override
    public void unloadBag(Bag bag) {
        bag.setShipmentStatus(ShipmentStatus.UNLOADED);
        if (bag.getPackList() != null)
            bag.getPackList().forEach(s -> s.setShipmentStatus(ShipmentStatus.UNLOADED));
    }

    @Override
    public void unloadPack(Pack pack) {
        pack.setShipmentStatus(ShipmentStatus.UNLOADED);
    }
}