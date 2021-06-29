package com.trucker.fleetmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trucker.fleetmanager.model.Readings;

@Repository
public interface ReadingsRepo extends CrudRepository<Readings, String>{

}
