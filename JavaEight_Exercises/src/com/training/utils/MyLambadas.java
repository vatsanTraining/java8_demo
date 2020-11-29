package com.training.utils;

import java.util.function.Predicate;

import com.training.domains.CreditCard;

public class MyLambadas {

	public static Predicate<CreditCard> checkLength(){
		
	
	
	Predicate<CreditCard> checkNameLength = (arg) -> 
    arg.getCardHolder().length() >3 && arg.getCardHolder().length()<8;

     return checkNameLength;
	}
	
	public static boolean check(CreditCard card) {
		
		return  card.getCardHolder().length()>6;
	}
	
	
	public double calculate(CreditCard card) {
		
		
		  return card.getCreditLimit() * .20;
		
	}
   
	public CreditCard card() {
		
		return new CreditCard(84848, "ramesh", 474747,"master");
	}
}
