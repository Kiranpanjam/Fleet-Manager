package com.trucker.fleetmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trucker.fleetmanager.model.Vehicle;
import com.trucker.fleetmanager.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/getVehicles")
	public List<Vehicle> getVehicles() {
		return vehicleService.getVehicles();
	}
	
	@PutMapping("/addVehicle")
	public void addVehicle(@RequestBody List<Vehicle> vehicles) {
		vehicleService.addVehicle(vehicles);
	}
	
	
	
}


