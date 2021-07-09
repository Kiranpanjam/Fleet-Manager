package com.trucker.fleetmanager.service;

import java.util.List;

import com.fasterxml.jackson.core.JacksonException;
import com.trucker.fleetmanager.model.AlertDetails;

public interface AlertService {
	void addAlert(AlertDetails alertDetails) throws JacksonException;
	
	List<AlertDetails> getAlerts(String vin);
	
	List<AlertDetails> getHighAlerts();
}
