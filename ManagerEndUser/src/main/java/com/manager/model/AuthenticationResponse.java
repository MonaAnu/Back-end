package com.manager.model;

public class AuthenticationResponse {
	private String name;
	private String role;
	private boolean isValid;

	public AuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationResponse(String name, String role, boolean isValid) {
		super();
		this.name = name;
		this.role = role;
		this.isValid = isValid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "AuthResponse [name=" + name + ", role=" + role + ", isValid=" + isValid + "]";
	}

}
