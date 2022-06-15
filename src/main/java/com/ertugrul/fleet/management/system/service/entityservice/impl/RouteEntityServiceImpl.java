package com.ertugrul.fleet.management.system.service.entityservice.impl;

import com.ertugrul.fleet.management.system.entity.Route;
import com.ertugrul.fleet.management.system.repository.RouteRepository;
import com.ertugrul.fleet.management.system.service.entityservice.RouteEntityService;
import org.springframework.stereotype.Service;

@Service
public class RouteEntityServiceImpl extends BaseEntityService<Route, RouteRepository> implements RouteEntityService {

    public RouteEntityServiceImpl(RouteRepository routeRepository) {
        super(routeRepository);
    }

}