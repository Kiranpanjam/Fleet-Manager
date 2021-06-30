package com.trucker.fleetmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.trucker.fleetmanager.model.AlertDetails;
import com.trucker.fleetmanager.service.AlertService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AlertsController {

	@Autowired
	private AlertService alertService;
	
	@ApiOperation(value = "Get alerts by vehicle id")
	@ApiResponses(value = { 
	  @ApiResponse(code = 200, message = "OK"),
	  @ApiResponse(code = 400, message = "Invalid vehicle ID supplied"), 
	  @ApiResponse(code = 404, message = "Alerts not found")
	  })
	@GetMapping("/alerts/{vin}")
	public List<AlertDetails> getAlerts(@PathVariable("vin") String vin){
		return alertService.getAlerts(vin);
	}
	
	@ApiOperation(value = "Get all high priority alerts in last two hours")
	@ApiResponses(value = { 
	  @ApiResponse(code = 200, message = "OK"),
	  @ApiResponse(code = 404, message = "Alerts not found")
	  })
	@GetMapping("/alerts")
	public List<AlertDetails> getHighAlerts(){
		return alertService.getHighAlerts();
	}
	
	
}
