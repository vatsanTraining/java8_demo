package com.training.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.training.domains.CreditCard;
import com.training.repo.CreditCardRepository;
import com.training.utils.MyLambadas;

public class CrediCardServiceWithMethodReference {

	private CreditCardRepository repo;

	private List<CreditCard> list ;
	public CrediCardServiceWithMethodReference() {
		
		super();
		
	      repo = new CreditCardRepository();
	      
	    list= repo.getList();    
	}

	
	// Method Reference - Example - 1
	public void showAll() {
		
		//list.forEach(eachItem -> System.out.println(eachItem));
		
		// replaced with a Method Reference
		
		 list.forEach(System.out::println);
		
	}
	
	// Method Reference - Example2
	public void checkName() {
		
		Predicate<CreditCard> condition= MyLambadas::check;
		
		for(CreditCard card : list) {
		   System.out.println("is Length Greater Than 6" +condition.test(card));
		}
		
	}
	
}
