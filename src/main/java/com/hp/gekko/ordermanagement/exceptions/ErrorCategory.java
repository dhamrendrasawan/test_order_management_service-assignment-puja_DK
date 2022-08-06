package com.hp.gekko.ordermanagement.exceptions;

public enum ErrorCategory {

	ValidationError("1001", "Data Validation Error"),
	ER0005("ER0005", "Customer record already exist with email Id {}"), ER0001("ER0001", "EmailId is required"),
	ER0002("ER0002", "City is required"), ER0003("ER0003", "ClassRoom is required"),
	ER0004("ER0004", "Customer record does not exist with given Id"),
	ER0006("ER0006", "Error Occured while creating new Customer Record ..!!");

	private String code;
	private String message;

	ErrorCategory(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}