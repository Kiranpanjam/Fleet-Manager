package com.trucker.fleetmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trucker.fleetmanager.model.AlertDetails;

@Repository
public interface AlertsRepo extends CrudRepository<AlertDetails, String>{
	List<AlertDetails> findAllByVin(String vin);

	@Query(value="SELECT * FROM alert_details WHERE time_stamp > NOW() - INTERVAL 2 HOUR and alert_priority = 'HIGH'", nativeQuery = true)
	List<AlertDetails> findAllByAlertPriority();
}
