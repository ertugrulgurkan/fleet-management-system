package com.ertugrul.fleet.management.system.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class PackDto implements Serializable {

    @NotBlank(message = "Barcode is mandatory")
    private String barcode;

    @NotNull(message = "Delivery Point number is mandatory")
    @Min(1)
    @Max(3)
    private Integer deliveryPointForUnloading;

    @Min(0)
    private Integer volumetricWeight;

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

    public Integer getVolumetricWeight() {
        return volumetricWeight;
    }

    public void setVolumetricWeight(Integer volumetricWeight) {
        this.volumetricWeight = volumetricWeight;
    }

    @Override
    public String toString() {
        return "Pack{" +
                "barcode='" + barcode + '\'' +
                ", deliveryPointForUnloading=" + deliveryPointForUnloading +
                ", volumetricWeight=" + volumetricWeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackDto packDto = (PackDto) o;
        return Objects.equals(barcode, packDto.barcode) && Objects.equals(deliveryPointForUnloading, packDto.deliveryPointForUnloading) && Objects.equals(volumetricWeight, packDto.volumetricWeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode, deliveryPointForUnloading, volumetricWeight);
    }
}
