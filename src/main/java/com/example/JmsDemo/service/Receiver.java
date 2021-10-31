package com.example.JmsDemo.service;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.Message;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import com.example.JmsDemo.model.Request;
import com.example.JmsDemo.model.Response;

@Component
public class Receiver  implements SessionAwareMessageListener<Message> {
	
    @Override
    @JmsListener(destination = "${app.request.q}")
    public void onMessage(Message message, Session session) throws JMSException {
    	
        Request req = (Request) ((ActiveMQObjectMessage) message).getObject();
        
        Response response = new Response(req.getId(), UUID.randomUUID().toString(), "Request was successful");

        // create a response message
        final ObjectMessage responseMessage = new ActiveMQObjectMessage();
        responseMessage.setJMSCorrelationID(message.getJMSCorrelationID());
        responseMessage.setObject(response);

        // Message sent back to the replyTo address of the income message.
        final MessageProducer producer = session.createProducer(message.getJMSReplyTo());
        producer.send(responseMessage);
    }
}