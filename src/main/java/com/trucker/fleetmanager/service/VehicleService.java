package com.trucker.fleetmanager.service;

import java.util.List;

import com.trucker.fleetmanager.model.Vehicle;

public interface VehicleService {
	
	void addVehicle(List<Vehicle> vechicles);
	List<Vehicle> getVehicles();
}
