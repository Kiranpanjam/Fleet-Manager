package com.trucker.fleetmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trucker.fleetmanager.model.AlertDetails;

@Repository
public interface AlertsRepo extends CrudRepository<AlertDetails, String>{

}
