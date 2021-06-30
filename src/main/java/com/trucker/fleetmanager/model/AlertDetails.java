package com.trucker.fleetmanager.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AlertDetails {

	@Id
	private String id;
	private String vin;
	private String alertPriority;
	private String alertDescription;
	private Timestamp timeStamp;
	
	public AlertDetails() {
		this.id = UUID.randomUUID().toString();
	}
	public String getId() {
		return id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getAlertPriority() {
		return alertPriority;
	}
	public void setAlertPriority(String alertPriority) {
		this.alertPriority = alertPriority;
	}
	public String getAlertDescription() {
		return alertDescription;
	}
	public void setAlertDescription(String alertDescription) {
		this.alertDescription = alertDescription;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "AlertDetails [vin=" + vin + ", alertPriority=" + alertPriority + ", alertDescription="
				+ alertDescription + ", timeStamp=" + timeStamp + "]";
	}
	
	
	
	
}
