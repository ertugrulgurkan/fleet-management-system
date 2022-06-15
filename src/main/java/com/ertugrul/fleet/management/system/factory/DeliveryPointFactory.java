package com.ertugrul.fleet.management.system.factory;

import com.ertugrul.fleet.management.system.entity.Branch;
import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.entity.DistributionCenter;
import com.ertugrul.fleet.management.system.entity.TransferCenter;
import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPointFactory {

    public DeliveryPoint getDeliveryPoint(DeliveryPointType type) {
        if (type == null)
            return null;
        return switch (type) {
            case BRANCH -> new Branch();
            case DISTRIBUTION_CENTER -> new DistributionCenter();
            case TRANSFER_CENTER -> new TransferCenter();
        };
    }

}
