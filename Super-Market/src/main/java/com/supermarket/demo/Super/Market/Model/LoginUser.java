package com.supermarket.demo.Super.Market.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class LoginUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="login_id")
	private Long loginId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="admin_role")
	private String adminRole;
	
	
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoginUser(Long loginId, String firstName, String lastName, String email, String password, String adminRole) {
		super();
		this.loginId = loginId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.adminRole = adminRole;
	}


	public Long getLoginId() {
		return loginId;
	}


	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public String getAdminRole() {
		return adminRole;
	}


	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}


	@Override
	public String toString() {
		return "LoginUser [loginId=" + loginId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", adminRole=" + adminRole + "]";
	}
	
	


	


	
	
	
}
	
	
