package com.trucker.fleetmanager.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trucker.fleetmanager.model.Vehicle;

@Repository
public interface VehicleRepo extends CrudRepository<Vehicle, String>{


}
