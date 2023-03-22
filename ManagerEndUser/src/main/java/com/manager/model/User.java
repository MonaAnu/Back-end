package com.manager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User 
{
	@Id
	private int id;
	private String userName;
	private String password;
	private boolean active;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public User(int id, String userName, String password, boolean active, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.role = role;
	}
	@Override
	public String toString() {
		return "Userentity [id=" + id + ", userName=" + userName + ", password=" + password + ", active=" + active
				+ ", role=" + role + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
