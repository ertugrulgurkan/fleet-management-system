package com.ertugrul.fleet.management.system.entity;


import com.ertugrul.fleet.management.system.enums.ShipmentStatus;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Slf4j
public class Bag extends Shipment {

    @OneToMany(targetEntity = Pack.class, mappedBy = "bag", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pack> packList = new ArrayList<>();

    public List<Pack> getPackList() {
        return packList;
    }

    public void setPackList(List<Pack> packList) {
        this.packList = packList;
    }

    @Override
    public void setShipmentToUnload(DeliveryPoint deliveryPoint) {
        if (deliveryPoint.type == this.getDeliveryPoint().type)
            deliveryPoint.unloadBag(this);
        else {
            this.setShipmentStatus(ShipmentStatus.LOADED);
            log.error("Error due to attempt to deliver to the wrong point. Barcode number: " + getBarcode());
        }
    }
}
