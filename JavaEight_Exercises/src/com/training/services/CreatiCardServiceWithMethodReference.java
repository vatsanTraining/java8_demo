package com.training.services;

import java.util.ArrayList;
import java.util.List;

import com.training.domains.CreditCard;
import com.training.repo.CreditCardRepository;

public class CreatiCardServiceWithMethodReference {

	private CreditCardRepository repo;

	private List<CreditCard> list ;
	public CreatiCardServiceWithMethodReference() {
		
		super();
		
	      repo = new CreditCardRepository();
	      
	       
	}

	
	public void showAll() {
		
		
		
	}
	
	
}
