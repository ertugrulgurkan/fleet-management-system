package com.ertugrul.fleet.management.system.enums;

public enum ShipmentStatus {
    NONE(0),
    CREATED(1),
    LOADED_INTO_BAG(2),
    LOADED(3),
    UNLOADED(4);

    private final Integer status;

    ShipmentStatus(Integer status) {
        this.status = status;

    }

    public Integer getStatus() {
        return status;
    }
}
