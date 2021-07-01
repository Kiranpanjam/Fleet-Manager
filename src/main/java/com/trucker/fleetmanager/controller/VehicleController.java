package com.trucker.fleetmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trucker.fleetmanager.model.Vehicle;
import com.trucker.fleetmanager.service.VehicleService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@ApiOperation(value = "Get all vehicles")
	@ApiResponses(value = { 
	  @ApiResponse(code = 200, message = "OK"),
	  @ApiResponse(code = 404, message = "Vehicles not found")
	  })
	@GetMapping("/vehicles")
	public List<Vehicle> getVehicles() {
		return vehicleService.getVehicles();
	}
	
	@ApiOperation(value = "Put vehicles into database")
	@ApiResponses(value = { 
	  @ApiResponse(code = 200, message = "OK"),
	  @ApiResponse(code = 400, message = "Invalid vehicle supplied")
	  })
	@PutMapping("/vehicles")
	public void addVehicle(@RequestBody List<Vehicle> vehicles) {
		vehicleService.addVehicle(vehicles);
	}
	
	
}


