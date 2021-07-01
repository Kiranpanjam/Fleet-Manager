package com.trucker.fleetmanager.service;

import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.trucker.fleetmanager.model.Vehicle;
import com.trucker.fleetmanager.repository.VehicleRepo;


@RunWith(SpringRunner.class)
public class VehicleServiceImplTest {
	
	@TestConfiguration
	static class VehicleServiceImplTestConfig {
		
		@Bean
		public VehicleService getService() {
			return new VehicleServiceImpl();
		}
	}
	
	@Autowired
	private VehicleService vehicleService;
	
	@MockBean
	private VehicleRepo vehicleRepo;
	
	private List<Vehicle> vehicles;
	
	@Before
	public void setup() {
		Vehicle vehicle = new Vehicle( );
		vehicle.setVin("XYZ");
		vehicle.setMake("HONDA");
		vehicle.setModel("ACCORD");
		vehicle.setYear(2010);
		vehicle.setRedlineRpm(3000);
		vehicle.setMaxFuelVolume(30);
		vehicle.setLastServiceDate(null);
		
		vehicles = Collections.singletonList(vehicle);
		
		Mockito.when(vehicleRepo.findAll())
				.thenReturn(vehicles);
	}
	
	@After
	public void cleanUp() {
		System.out.println("After");
	}

	@Test
	public void testAddVehicle() {
		//fail("Not yet implemented");
	}

	
	@Test
	public void testGetVehicles() {
		List<Vehicle> local_vehicles = (List<Vehicle>) vehicleService.getVehicles();
		
		Assert.assertEquals("Vehicles list should match", vehicles, local_vehicles);
	}

}
