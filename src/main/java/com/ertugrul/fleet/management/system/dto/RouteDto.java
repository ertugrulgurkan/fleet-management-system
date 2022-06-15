package com.ertugrul.fleet.management.system.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class RouteDto implements Serializable {
    @NotNull(message = "Delivery point is mandatory")
    private int deliveryPoint;

    @NotNull
    @NotEmpty
    @Size(min = 1)
    private List<ShipmentDto> deliveries;

    public int getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(int deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public List<ShipmentDto> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<ShipmentDto> deliveries) {
        this.deliveries = deliveries;
    }

    @Override
    public String toString() {
        return "{" +
                "deliveryPoint=" + deliveryPoint +
                ", deliveries=" + deliveries +
                '}';
    }
}
