package com.ertugrul.fleet.management.system.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class BagDto implements Serializable {

    @NotBlank(message = "Barcode is mandatory")
    private String barcode;

    @NotNull(message = "Delivery Point number is mandatory")
    @Min(1)
    @Max(3)
    private Integer deliveryPointForUnloading;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getDeliveryPointForUnloading() {
        return deliveryPointForUnloading;
    }

    public void setDeliveryPointForUnloading(Integer deliveryPointForUnloading) {
        this.deliveryPointForUnloading = deliveryPointForUnloading;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "barcode='" + barcode + '\'' +
                ", deliveryPointForUnloading=" + deliveryPointForUnloading +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BagDto bagDto = (BagDto) o;
        return Objects.equals(barcode, bagDto.barcode) && Objects.equals(deliveryPointForUnloading, bagDto.deliveryPointForUnloading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode, deliveryPointForUnloading);
    }
}
