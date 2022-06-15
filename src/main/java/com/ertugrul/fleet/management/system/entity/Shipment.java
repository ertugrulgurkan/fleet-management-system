package com.ertugrul.fleet.management.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ertugrul.fleet.management.system.enums.ShipmentStatus;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Shipment extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String barcode;

    private ShipmentStatus shipmentStatus = ShipmentStatus.CREATED;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_point_type", referencedColumnName = "type", nullable = false)
    private DeliveryPoint deliveryPoint;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;

    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(ShipmentStatus shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public DeliveryPoint getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(DeliveryPoint deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public abstract void setShipmentToUnload(DeliveryPoint deliveryPoint);

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
