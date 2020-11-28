package com.training.utils;

import java.util.function.Predicate;

import com.training.domains.CreditCard;

public class MyLambadas {

	public static Predicate<CreditCard> checkLength(){
		
	
	
	Predicate<CreditCard> checkNameLength = (arg) -> 
    arg.getCardHolder().length() >3 && arg.getCardHolder().length()<8;

     return checkNameLength;
	}
}
