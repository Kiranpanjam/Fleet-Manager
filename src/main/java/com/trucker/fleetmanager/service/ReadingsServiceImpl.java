package com.trucker.fleetmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trucker.fleetmanager.model.Readings;
import com.trucker.fleetmanager.repository.ReadingsRepo;

@Service
public class ReadingsServiceImpl implements ReadingsService {

	@Autowired
	private ReadingsRepo readingsRepo;
	
	@Override
	public void addReadings(Readings reading) {
		// TODO Auto-generated method stub
		readingsRepo.save(reading);
	}

}
