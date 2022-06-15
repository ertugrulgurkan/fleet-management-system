package com.ertugrul.fleet.management.system.repository;

import com.ertugrul.fleet.management.system.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
