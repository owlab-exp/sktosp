package com.skt.opensocial.developer;

public class ValidationMessage {
	private boolean isValid = false;
	private String message;
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
