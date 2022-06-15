package com.ertugrul.fleet.management.system.dto;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

public class VehicleDto implements Serializable {

    @NotBlank(message = "Plate number is mandatory")
    private String licencePlate;

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licencePlate='" + licencePlate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleDto that = (VehicleDto) o;
        return Objects.equals(licencePlate, that.licencePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licencePlate);
    }
}
