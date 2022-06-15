package com.ertugrul.fleet.management.system.entity;

import com.ertugrul.fleet.management.system.enums.ShipmentStatus;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Slf4j
public class Pack extends Shipment {
    private Integer volumetricWeight;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bag_id", referencedColumnName = "id")
    private Bag bag;

    public Integer getVolumetricWeight() {
        return volumetricWeight;
    }

    public void setVolumetricWeight(Integer volumetricWeight) {
        this.volumetricWeight = volumetricWeight;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    @Override
    public void setShipmentToUnload(DeliveryPoint deliveryPoint) {
        if (deliveryPoint.type == this.getDeliveryPoint().type)
            deliveryPoint.unloadPack(this);
        else {
            this.setShipmentStatus(ShipmentStatus.LOADED);
            log.error("Pack: Error due to attempt to deliver to the wrong point. Barcode number: " + getBarcode());
        }
    }
}
