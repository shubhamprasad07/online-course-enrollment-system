package com.capgemini.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long userID;
	
	@NotBlank(message = "User Name Can't be Empty")
	@Size(min = 3, message = "User Name should be greater than 3 character")
	protected String name;
	
	@NotBlank(message = "User Email Can't be Empty")
	@Size(min = 3, message = "User Email should be greater than 3 character")
	protected String email;
	
	@NotBlank(message = "User Password Can't be Empty")
	@Size(min = 3, message = "User Password should be greater than 3 character")
	protected String password;
	
	@NotNull(message = "User Phone Number Can't be Empty")
	protected long phone;
	
	@NotBlank(message = "User Type Can't be Empty")
	@Size(min = 3, message = "User Type should be greater than 3 character")
	protected String userType;
	
	public User() {
	}

	public User(long userID, String name, String email, String password, long phone, String userType) {
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.userType = userType;
	}
	
	public User(String name, String email, String password, long phone, String userType) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.userType = userType;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "userID=" + userID + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", userType=" + userType;
	}
	
}
