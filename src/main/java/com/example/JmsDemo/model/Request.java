package com.example.JmsDemo.model;

import java.io.Serializable;

public class Request implements Serializable {
	
	private String id;
	private String mobile;
	private String email;
	private String account;
	

	public Request() {
		this.id = "";
		this.mobile = "";
		this.email = "";
		this.account = "";
	}


	public Request(String id, String mobile, String email, String account) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.email = email;
		this.account = account;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "Request [id=" + id + ", mobile=" + mobile + ", email=" + email + ", account=" + account + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
