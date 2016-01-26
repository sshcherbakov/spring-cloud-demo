package io.pivotal.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MainResponse {

	private String message;
	private String serviceId;

	@JsonCreator
	public MainResponse(
			@JsonProperty("message") String message, 
			@JsonProperty("appId") String appId) {
		
		this.message = message;
		this.serviceId = appId;
	}

	public String getMessage() {
		return message;
	}

	public String getAppId() {
		return serviceId;
	}
	
}
