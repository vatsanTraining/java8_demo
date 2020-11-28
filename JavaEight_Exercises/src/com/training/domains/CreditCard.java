package com.training.domains;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor

@FieldDefaults(level=AccessLevel.PRIVATE)
public class CreditCard {

	 long cardNumber;
	 String cardHolder;
	 double creditLimit;
	 
	 
}
