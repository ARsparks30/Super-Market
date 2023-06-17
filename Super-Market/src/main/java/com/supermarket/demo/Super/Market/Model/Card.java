package com.supermarket.demo.Super.Market.Model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="card_id")
	private Long cardId;
	@Column(name="card_number")
	private Long cardNumber;
	@Column(name="card_cvv")
	private Long cardCvv;
	@Column(name="cash")
	private Double cash;
	
	
	
	
	
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}






	public Card(Long cardId, Long cardNumber, Long cardCvv, Double cash) {
		super();
		this.cardId = cardId;
		this.cardNumber = cardNumber;
		this.cardCvv = cardCvv;
		this.cash = cash;
	}
	
	






	






	@Override
	public int hashCode() {
		return Objects.hash(cardCvv, cardId, cardNumber, cash);
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(cardCvv, other.cardCvv) && Objects.equals(cardId, other.cardId)
				&& Objects.equals(cardNumber, other.cardNumber) && Objects.equals(cash, other.cash);
	}






	public Long getCardId() {
		return cardId;
	}






	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}






	public Long getCardNumber() {
		return cardNumber;
	}






	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}






	public Long getCardCvv() {
		return cardCvv;
	}






	public void setCardCvv(Long cardCvv) {
		this.cardCvv = cardCvv;
	}






	public Double getCash() {
		return cash;
	}






	public void setCash(Double cash) {
		this.cash = cash;
	}






	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardNumber=" + cardNumber + ", cardCvv=" + cardCvv + ", cash=" + cash
				+ "]";
	}
	
	






	
	
	
	
	
	
	
	
}
