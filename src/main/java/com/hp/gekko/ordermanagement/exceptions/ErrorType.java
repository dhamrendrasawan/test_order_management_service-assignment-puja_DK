package com.hp.gekko.ordermanagement.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorType {

	private Error error;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "Code", "Field", "Message" })
	@Builder
	@Data
	public static class Errors {

		@JsonProperty("Code")
		private String code;
		@JsonProperty("Field")
		private String field;
		@JsonProperty("Message")
		private String message;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "Code", "Type", "Message", "DeveloperMessage", "MoreInfo", "Timestamp", "Status", "Errors" })
	@Builder
	@Data
	public static class Error {

		@JsonProperty("Code")
		private String code;
		@JsonProperty("Type")
		private String type;
		@JsonProperty("Message")
		private String message;
		@JsonProperty("DeveloperMessage")
		private String developerMessage;
		@JsonProperty("MoreInfo")
		private String moreInfo;
		@JsonProperty("Timestamp")
		private String timestamp;
		@JsonProperty("Status")
		private String status;
		@JsonProperty("Errors")
		private List<Errors> errors = null;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	}
}