package com.ertugrul.fleet.management.system.factory;

import com.ertugrul.fleet.management.system.entity.Branch;
import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.entity.DistributionCenter;
import com.ertugrul.fleet.management.system.entity.TransferCenter;
import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DeliveryPointFactoryTest {

    DeliveryPointFactory deliveryPointFactory;

    @BeforeEach
    void setUp() {
        deliveryPointFactory = new DeliveryPointFactory();
    }

    @Test
    void getDeliveryPointBranch() {
        DeliveryPoint expected = new Branch();
        DeliveryPoint actual = deliveryPointFactory.getDeliveryPoint(DeliveryPointType.BRANCH);
        Assertions.assertEquals(expected.getType(), actual.getType());
    }

    @Test
    void getDeliveryPointDistributionCenter() {
        DeliveryPoint expected = new DistributionCenter();
        DeliveryPoint actual = deliveryPointFactory.getDeliveryPoint(DeliveryPointType.DISTRIBUTION_CENTER);
        Assertions.assertEquals(expected.getType(), actual.getType());
    }

    @Test
    void getDeliveryPointTransferCenter() {
        DeliveryPoint expected = new TransferCenter();
        DeliveryPoint actual = deliveryPointFactory.getDeliveryPoint(DeliveryPointType.TRANSFER_CENTER);
        Assertions.assertEquals(expected.getType(), actual.getType());
    }

    @Test
    void getNullDeliveryPoint() {
        DeliveryPoint actual = deliveryPointFactory.getDeliveryPoint(null);
        assertNull(actual);
    }


}