package com.trucker.fleetmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trucker.fleetmanager.model.Vehicle;
import com.trucker.fleetmanager.repository.VehicleRepo;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepo vehicleRepo; 
	
	@Override
	public void addVehicle(List<Vehicle> vehicles) {
		// TODO Auto-generated method stub
		for(Vehicle vehicle : vehicles) {
			vehicleRepo.save(vehicle);
			System.out.println(vehicle);
		}
	}

	@Override
	public List<Vehicle> getVehicles() {
		return (List<Vehicle>) vehicleRepo.findAll();
	}

}
