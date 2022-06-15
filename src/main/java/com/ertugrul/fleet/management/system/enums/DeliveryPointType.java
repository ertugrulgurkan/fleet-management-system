package com.ertugrul.fleet.management.system.enums;

import java.util.Arrays;
import java.util.Objects;

public enum DeliveryPointType {
    BRANCH(1),
    DISTRIBUTION_CENTER(2),
    TRANSFER_CENTER(3);

    private final Integer value;

    DeliveryPointType(Integer value) {
        this.value = value;

    }

    public static DeliveryPointType getByInteger(Integer value) {
        return Arrays.stream(DeliveryPointType.values())
                .filter(deliveryPointType -> Objects.equals(deliveryPointType.value, value))
                .findFirst()
                .orElse(DeliveryPointType.BRANCH);
    }

    public Integer getValue() {
        return value;
    }
}
