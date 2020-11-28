package com.training.services;
import java.util.*;

import com.training.domains.CreditCard;
import com.training.ifaces.CheckEligibility;
import com.training.repo.CreditCardRepository;

import java.util.function.Consumer;
public class CreditCardService {

	
	private CreditCardRepository repo;

	public CreditCardService() {
		super();
          repo = new CreditCardRepository();
	}
	
	
	public void display() {
		
		Set<Map.Entry<Long,CreditCard>> list = repo.findAll();
		
		list.forEach( (args) -> System.out.println(args.getValue()));
	}
	
	public void checkForLoanEligibility() {
		
		Set<Map.Entry<Long,CreditCard>> list = repo.findAll();
		
		CheckEligibility<CreditCard> check = (card) -> card.getCreditLimit() >300000;
		
		
		for(Map.Entry<Long, CreditCard> eachItem : list) {
			
			CreditCard card = eachItem.getValue();
			
			 if(check.test(card)) {
				 
				 System.out.println(card.getCardHolder());
			 }
		}
		
	}
}
