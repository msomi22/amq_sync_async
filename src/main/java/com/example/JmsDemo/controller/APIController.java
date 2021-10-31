package com.example.JmsDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JmsDemo.model.Request;
import com.example.JmsDemo.model.Response;
import com.example.JmsDemo.service.Producer;

@RestController
@RequestMapping("/send")
public class APIController {
	
	@Autowired
	private Producer producer;

	@PostMapping(value="/v1", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Response send(@RequestBody Request req) {
		System.out.println("Received request " + req);
		if(req.getAccount().isEmpty())
			return producer.sendWithAck(req);
	    return producer.sendWithReply(req);
	}
}
