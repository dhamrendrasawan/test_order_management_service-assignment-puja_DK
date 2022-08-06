package com.hp.gekko.ordermanagement.exceptions;

public class APIGenericValidationError extends RuntimeException {

	private String code;
	private String message;
	private String errorCode;
	private String errorMessage;

	public APIGenericValidationError(String code, String message, String errorCode, String errorMessage) {
		this.code = code;
		this.message = message;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}