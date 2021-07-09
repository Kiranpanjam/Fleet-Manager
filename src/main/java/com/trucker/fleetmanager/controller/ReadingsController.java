package com.trucker.fleetmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JacksonException;
import com.trucker.fleetmanager.model.Readings;
import com.trucker.fleetmanager.rules.Alerts;
import com.trucker.fleetmanager.service.ReadingsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ReadingsController {

	@Autowired
	private ReadingsService readingsService;
	@Autowired
	private Alerts alerts;
	
	
	@ApiOperation(value = "Post readings to database")
	@ApiResponses(value = { 
	  @ApiResponse(code = 200, message = "OK"),
	  @ApiResponse(code = 400, message = "Invalid ")
	  })
	@PostMapping("/readings")
	public void addReadings(@RequestBody Readings reading) throws JacksonException {
		readingsService.addReadings(reading);
		alerts.runAlerts(reading);
	}
}
