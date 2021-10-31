package com.example.JmsDemo.model;

import java.io.Serializable;

public class Response implements Serializable {
	
	
	private String originatorId;
	private String id;
	private String message;

	public Response() {
		
	}

	public Response(String originatorId, String id, String message) {
	  this.originatorId = originatorId;
	  this.id = id;
	  this.message = message;
	}

	public String getOriginatorId() {
		return originatorId;
	}

	public void setOriginatorId(String originatorId) {
		this.originatorId = originatorId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Response [originatorId=" + originatorId + ", id=" + id + ", message=" + message + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
