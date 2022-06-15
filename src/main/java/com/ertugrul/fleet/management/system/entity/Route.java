package com.ertugrul.fleet.management.system.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Route extends BaseEntity {

    @ManyToOne(targetEntity = Vehicle.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle", referencedColumnName = "licencePlate", nullable = false)
    private Vehicle vehicle;

    @OneToMany(targetEntity = Shipment.class, mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Shipment> shipmentList = new ArrayList<>();

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Shipment> getShipmentList() {
        return shipmentList;
    }

    public void setShipmentList(List<Shipment> shipmentList) {
        this.shipmentList = shipmentList;
    }
}
