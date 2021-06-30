package com.trucker.fleetmanager.rules;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trucker.fleetmanager.model.AlertDetails;
import com.trucker.fleetmanager.model.Readings;
import com.trucker.fleetmanager.model.Vehicle;
import com.trucker.fleetmanager.repository.VehicleRepo;
import com.trucker.fleetmanager.service.AlertService;

@Component
public class Alerts {
	
	@Autowired
	private VehicleRepo vehicleRepo;
	@Autowired
	private AlertService alertService;
	
	
	
	public void runAlerts(Readings readings) {
		
		//check tire pressure
		if(readings.getTires().getFrontLeft() < 32 || readings.getTires().getFrontLeft() > 36 ||
		   readings.getTires().getFrontRight() < 32 || readings.getTires().getFrontRight() > 36 ||
		   readings.getTires().getRearLeft() < 32 || readings.getTires().getRearLeft() > 36 ||
		   readings.getTires().getRearRight() < 32 || readings.getTires().getRearRight() > 36) {
			AlertDetails alertDetails = new AlertDetails();
			alertDetails.setVin(readings.getVin());
			alertDetails.setAlertPriority("LOW");
			alertDetails.setAlertDescription("Check tire pressure...");
			alertDetails.setTimeStamp(readings.getTimestamp());
			System.out.println(alertDetails);
			alertService.addAlert(alertDetails);
		}
		
		//check engine and engine light
		if(readings.isCheckEngineLightOn() || readings.isEngineCoolantLow()) {
			AlertDetails alertDetails = new AlertDetails();
			alertDetails.setVin(readings.getVin());
			alertDetails.setAlertPriority("LOW");
			alertDetails.setAlertDescription("Check engine light and coolant...");
			alertDetails.setTimeStamp(readings.getTimestamp());
			System.out.println(alertDetails);
			alertService.addAlert(alertDetails);

		}
		
		
		//check engine speed
		String vehicle_id = readings.getVin();
		Optional<Vehicle> vehicle = vehicleRepo.findById(vehicle_id);
		if(vehicle.isPresent()) {
			if(readings.getEngineRpm() > vehicle.get().getRedlineRpm()) {
				AlertDetails alertDetails = new AlertDetails();
				alertDetails.setVin(readings.getVin());
				alertDetails.setAlertPriority("HIGH");
				alertDetails.setAlertDescription("Engine RPM is higher...");
				alertDetails.setTimeStamp(readings.getTimestamp());
				System.out.println(alertDetails);
				alertService.addAlert(alertDetails);

			}
			
			if(readings.getFuelVolume() < (0.1 * vehicle.get().getMaxFuelVolume())) {
				AlertDetails alertDetails = new AlertDetails();
				alertDetails.setVin(readings.getVin());
				alertDetails.setAlertPriority("MEDIUM");
				alertDetails.setAlertDescription("Fuel is less than 10%...");
				alertDetails.setTimeStamp(readings.getTimestamp());
				System.out.println(alertDetails);
				alertService.addAlert(alertDetails);

			}
		}
		
	}
}
