package com.trucker.fleetmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trucker.fleetmanager.model.Readings;
import com.trucker.fleetmanager.service.ReadingsService;

@RestController
public class ReadingsController {

	@Autowired
	private ReadingsService readingsService;
	
	@PostMapping("/addReadings")
	public void addReadings(@RequestBody Readings reading) {
		System.out.println("Reading controller executed...");
		readingsService.addReadings(reading);
	}
}
