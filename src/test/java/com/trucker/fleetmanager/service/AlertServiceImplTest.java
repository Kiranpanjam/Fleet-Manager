package com.trucker.fleetmanager.service;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.trucker.fleetmanager.model.AlertDetails;
import com.trucker.fleetmanager.repository.AlertsRepo;

@RunWith(SpringRunner.class)
public class AlertServiceImplTest {

	@TestConfiguration
	static class AlertServiceImplTestConfig {
		
		@Bean
		public AlertService getService() {
			System.out.println("Implementing bean");
			return new AlertServiceImpl();
		}
	}

	@Autowired
	private AlertService alertService;

	@MockBean
	private AlertsRepo alertsRepo;

	private List<AlertDetails> alertDetails;

	@Before
	public void setup() {
		AlertDetails details = new AlertDetails();
		details.setVin("XYZID123456");
		details.setAlertPriority("HIGH");
		details.setAlertDescription("This is a test description of high alert");
		details.setTimeStamp(null);

		alertDetails = Collections.singletonList(details);

		Mockito.when(alertsRepo.findAllByVin("XYZID123456")).thenReturn(alertDetails);
		
		Mockito.when(alertsRepo.findAllByAlertPriority()).thenReturn(alertDetails);
	}

	@Test
	void testGetAlerts() {
//		List<AlertDetails> local_alerts = (List<AlertDetails>) alertService.getAlerts("XYZID123456");
//		
//		Assert.assertEquals("AlertsList should match", alertDetails, local_alerts);
	}

	@Test
	void testGetHighAlerts() {
//		List<AlertDetails> local_alerts = alertService.getHighAlerts();
//
//		Assert.assertEquals("AlertsList should match", alertDetails, local_alerts);

		// success("Not yet implemented");
	}

}
