package com.trucker.fleetmanager.awsmessaging;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class HighAlertsSNS {

	@Value("${sns.highalert.topic}")
	private String topic;

	private final NotificationMessagingTemplate notificationMessagingTemplate;

	@Autowired
	public HighAlertsSNS(NotificationMessagingTemplate notificationMessagingTemplate) {
		this.notificationMessagingTemplate = notificationMessagingTemplate;
	}

	public void send(String subject, String message) {
		this.notificationMessagingTemplate.sendNotification(topic, message, subject);
	}
}

