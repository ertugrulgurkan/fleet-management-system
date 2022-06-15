package com.ertugrul.fleet.management.system.repository;

import com.ertugrul.fleet.management.system.entity.DeliveryPoint;
import com.ertugrul.fleet.management.system.enums.DeliveryPointType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryPointRepository<T extends DeliveryPoint> extends JpaRepository<T, Long> {
    @Query("SELECT d FROM DeliveryPoint d WHERE d.type =:deliveryPointType")
    Optional<DeliveryPoint> findDeliveryPointByType(DeliveryPointType deliveryPointType);
}
