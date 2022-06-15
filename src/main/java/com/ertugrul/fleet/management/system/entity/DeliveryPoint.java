package com.ertugrul.fleet.management.system.entity;

import com.ertugrul.fleet.management.system.enums.DeliveryPointType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public abstract class DeliveryPoint extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    protected DeliveryPointType type;

    @Column(nullable = false)
    private String name;

    @OneToMany(targetEntity = Shipment.class, mappedBy = "deliveryPoint", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Shipment> deliveries = new ArrayList<>();

    public List<Shipment> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Shipment> deliveries) {
        this.deliveries = deliveries;
    }

    public abstract void unloadBag(Bag bag);

    public abstract void unloadPack(Pack pack);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeliveryPointType getType() {
        return type;
    }
}
