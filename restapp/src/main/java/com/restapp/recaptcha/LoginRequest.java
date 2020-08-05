package com.restapp.recaptcha;

public class LoginRequest {
	
	private String clientName;
	private String password;
	private String recaptchaResponse;
	
	public LoginRequest() {
		super();
	}
	
	public LoginRequest(String clientName, String password, String recaptchaResponse) {
		super();
		this.clientName = clientName;
		this.password = password;
		this.recaptchaResponse = recaptchaResponse;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRecaptchaResponse() {
		return recaptchaResponse;
	}

	public void setRecaptchaResponse(String recaptchaResponse) {
		this.recaptchaResponse = recaptchaResponse;
	}

}
