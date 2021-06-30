package com.trucker.fleetmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trucker.fleetmanager.model.AlertDetails;
import com.trucker.fleetmanager.repository.AlertsRepo;

@Service
public class AlertServiceImpl implements AlertService {

	@Autowired
	private AlertsRepo alertsRepo;
	
	
	@Override
	public void addAlert(AlertDetails alertDetails) {
		// TODO Auto-generated method stub
		alertsRepo.save(alertDetails);
	}

}
