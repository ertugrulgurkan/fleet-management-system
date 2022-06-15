package com.ertugrul.fleet.management.system.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class DeliveryPointDto implements Serializable {

    @NotNull(message = "Delivery Point number is mandatory")
    @Min(1)
    @Max(3)
    private int deliveryPointType;
    @NotBlank(message = "Name is mandatory")
    private String name;

    public int getDeliveryPointType() {
        return deliveryPointType;
    }

    public void setDeliveryPointType(int deliveryPointType) {
        this.deliveryPointType = deliveryPointType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "DeliveryPoint{" +
                "type=" + deliveryPointType +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryPointDto that = (DeliveryPointDto) o;
        return deliveryPointType == that.deliveryPointType && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryPointType, name);
    }
}
