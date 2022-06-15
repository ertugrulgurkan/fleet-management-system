package com.ertugrul.fleet.management.system.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class DeliveryDto implements Serializable {

    @NotBlank(message = "Plate number is mandatory")
    private String plate;

    @NotNull
    @NotEmpty
    @Size(min = 1)
    private List<RouteDto> route;

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public List<RouteDto> getRoute() {
        return route;
    }

    public void setRoute(List<RouteDto> route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "plate='" + plate + '\'' +
                ", route=" + route +
                '}';
    }
}
