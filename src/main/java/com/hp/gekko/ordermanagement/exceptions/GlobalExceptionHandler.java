package com.hp.gekko.ordermanagement.exceptions;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = APIGenericValidationError.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorType.Error handleFieldValidationError(APIGenericValidationError apiGenericValidationError,
			WebRequest webRequest) {

		ErrorType.Error error = ErrorType.Error.builder().developerMessage(apiGenericValidationError.getErrorMessage())
				.code(apiGenericValidationError.getCode()).message(apiGenericValidationError.getMessage())
				.timestamp(new Date().toString()).status(Integer.toString(HttpStatus.BAD_REQUEST.value())).build();

		return error;
	}

}
