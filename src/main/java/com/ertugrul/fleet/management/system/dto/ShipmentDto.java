package com.ertugrul.fleet.management.system.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ShipmentDto implements Serializable {
    @NotBlank(message = "Barcode is mandatory")
    private String barcode;
    private int state;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "{" +
                "barcode='" + barcode + '\'' +
                ", state=" + state +
                '}';
    }
}
