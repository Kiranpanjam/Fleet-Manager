package com.trucker.fleetmanager.service;

import java.util.List;

import com.trucker.fleetmanager.model.AlertDetails;

public interface AlertService {
	void addAlert(AlertDetails alertDetails);
	
	List<AlertDetails> getAlerts(String vin);
	
	List<AlertDetails> getHighAlerts();
}
