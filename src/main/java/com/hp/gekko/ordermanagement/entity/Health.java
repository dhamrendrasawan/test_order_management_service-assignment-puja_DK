package com.hp.gekko.ordermanagement.entity;

public class Health {

	private String name = "service-quickstart";
	private String status;

	public Health(String name, String status) {
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return this.name;
	}

	public String getStatus() {
		return this.status;
	}
}
