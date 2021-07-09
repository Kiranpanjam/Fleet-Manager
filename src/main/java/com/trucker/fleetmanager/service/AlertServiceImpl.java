package com.trucker.fleetmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trucker.fleetmanager.awsmessaging.HighAlertsSNS;
import com.trucker.fleetmanager.model.AlertDetails;
import com.trucker.fleetmanager.repository.AlertsRepo;

@Service
public class AlertServiceImpl implements AlertService {

	@Autowired
	private AlertsRepo alertsRepo;
	
	
	@Override
	public void addAlert(AlertDetails alertDetails) throws JacksonException {
		// TODO Auto-generated method stub
		alertsRepo.save(alertDetails);
		
	}


	@Override
	public List<AlertDetails> getAlerts(String vin) {
		// TODO Auto-generated method stub
		return alertsRepo.findAllByVin(vin);
	}


	@Override
	public List<AlertDetails> getHighAlerts() {
		// TODO Auto-generated method stub		
		return alertsRepo.findAllByAlertPriority();
	}


	
	

}
