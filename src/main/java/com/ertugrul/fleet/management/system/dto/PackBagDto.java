package com.ertugrul.fleet.management.system.dto;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class PackBagDto implements Serializable {
    @NotBlank(message = "Barcode is mandatory")
    private String barcode;

    @NotBlank(message = "Bag barcode is mandatory")
    private String bagBarcode;

    public String getBagBarcode() {
        return bagBarcode;
    }

    public void setBagBarcode(String bagBarcode) {
        this.bagBarcode = bagBarcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "PackBag{" +
                "barcode='" + barcode + '\'' +
                ", bagBarcode='" + bagBarcode + '\'' +
                '}';
    }
}
