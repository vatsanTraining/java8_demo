package com.training.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
	
	// Method Reference - Static Example2
	public void checkName() {
		
		Predicate<CreditCard> condition= MyLambadas::check;
		
		for(CreditCard card : list) {
		   System.out.println("is Length Greater Than 6" +condition.test(card));
		}
		
	}
	
	// Method Reference - Instance Method Example3
	
	public void calculate() {
		
		MyLambadas lambda = new MyLambadas();
		
		//Function<CreditCard,Double> funcRef = (card) -> card.getCreditLimit() *.20;

		Function<CreditCard,Double> funcRef = lambda::calculate;
		
		for(CreditCard card : list) {
			   System.out.println("is Length Greater Than 6" +funcRef.apply(card));
			}

		
	}

	// Method Reference - Constructor Example 4
	
	public void createObject() {
		
		
		Supplier<MyLambadas> card = MyLambadas::new;
		
		  MyLambadas obj =card.get();
		  
		   System.out.println(obj);
		
	}
}
