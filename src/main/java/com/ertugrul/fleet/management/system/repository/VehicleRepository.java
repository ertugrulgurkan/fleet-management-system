package com.ertugrul.fleet.management.system.repository;

import com.ertugrul.fleet.management.system.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findVehicleByLicencePlate(String licencePlate);
}
