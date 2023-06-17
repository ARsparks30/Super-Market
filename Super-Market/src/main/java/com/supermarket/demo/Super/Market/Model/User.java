package com.supermarket.demo.Super.Market.Model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="card_number")
	private Long cardNumber;
	@Column(name="card_cvv")
	private Double cardCvv;
	
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




	public User(Long userId, String firstName, String lastName, String email, String password, Long cardNumber,
			Double cardCvv) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.cardNumber = cardNumber;
		this.cardCvv = cardCvv;
	}




	public Long getUserId() {
		return userId;
	}




	public void setUserId(Long userId) {
		this.userId = userId;
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




	public Long getCardNumber() {
		return cardNumber;
	}




	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}




	public Double getCardCvv() {
		return cardCvv;
	}




	public void setCardCvv(Double cardCvv) {
		this.cardCvv = cardCvv;
	}




	




	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", cardNumber=" + cardNumber + ", cardCvv=" + cardCvv + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(cardCvv, cardNumber, email, firstName, lastName, password, userId);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cardCvv, other.cardCvv) && Objects.equals(cardNumber, other.cardNumber)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(userId, other.userId);
	}
	
	
	





	
	
	
	
	
	
	
	
	
}
