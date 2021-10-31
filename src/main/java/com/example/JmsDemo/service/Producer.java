package com.example.JmsDemo.service;

import java.util.UUID;

import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties.DeliveryMode;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.JmsDemo.ActiveMQConfig;
import com.example.JmsDemo.model.Request;
import com.example.JmsDemo.model.Response;


@Service
public class Producer extends ActiveMQConfig {

	@Autowired
	JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	JmsTemplate jmsTemplate;

	public Response sendWithReply(Request req) {
		
		System.out.println("Processing Request " + req);
		try {
			jmsTemplate.setReceiveTimeout(1000L);
			jmsMessagingTemplate.setJmsTemplate(jmsTemplate);

			Session session = jmsMessagingTemplate
					.getConnectionFactory()
					.createConnection().createSession(false,Session.AUTO_ACKNOWLEDGE);

			ObjectMessage objectMessage = session.createObjectMessage(req);

			objectMessage.setJMSCorrelationID(UUID.randomUUID().toString());
			objectMessage.setJMSReplyTo(new ActiveMQQueue(REQUEST_REPLY_2_QUEUE));
			objectMessage.setJMSCorrelationID(UUID.randomUUID().toString());
			objectMessage.setJMSExpiration(1000L);
			objectMessage.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT.getValue());
			
			System.out.println("Message Sent!  ");

			// this operation seems to be blocking + sync
			return jmsMessagingTemplate
					.convertSendAndReceive(new ActiveMQQueue(REQUEST_QUEUE), objectMessage,
					Response.class); 
		} catch (Exception e) {
			System.err.println("Error: " + e);
			e.printStackTrace();
			return null;
		}
	}
}