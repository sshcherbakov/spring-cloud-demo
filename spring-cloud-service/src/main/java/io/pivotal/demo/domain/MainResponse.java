package io.pivotal.demo.domain;

public class MainResponse {

	private String message;
	private String serviceId;

	public MainResponse(String message, String appId) {
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
