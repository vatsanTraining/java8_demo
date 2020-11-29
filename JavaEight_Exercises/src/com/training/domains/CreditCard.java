package com.training.domains;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Data

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class CreditCard {

	 long cardNumber;
	 String cardHolder;
	 double creditLimit;
	 String cardProvider;
	 LocalDate cardExpiryDate;
	 LocalDateTime cardHolderBirthDay;
	 
	public CreditCard(long cardNumber, String cardHolder, double creditLimit, String cardProvider) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.creditLimit = creditLimit;
		this.cardProvider = cardProvider;
	}
	 
	 
	 
	 
}
