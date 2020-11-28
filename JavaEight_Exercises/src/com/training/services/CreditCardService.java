package com.training.services;
import java.util.*;

import com.training.domains.CreditCard;
import com.training.ifaces.CheckEligibility;
import com.training.repo.CreditCardRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.Predicate;


@Slf4j
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
				 
				 log.info(card.getCardHolder());
			 }
		}
		
	}
	
	// Using Predicate functional Interface
	public void checkCardHolderName() {
	
		CreditCard card = this.repo.findById(1021);
		
		Predicate<CreditCard> checkNameLength = (arg) -> 
		             arg.getCardHolder().length() >3 && arg.getCardHolder().length()<8;
		
		if( checkNameLength.test(card)) {
			System.out.println("Valid Name");
		} else {
			
			System.out.println("Invalid Name");
		}
		
	}
	
	// Using Predicate functional Interface and Its Default Method
		public void checkCardHolderName(long id) {
		
			CreditCard card = this.repo.findById(id);
			
			Predicate<CreditCard> checkNameLength = (arg) -> 
			             arg.getCardHolder().length() >3 && arg.getCardHolder().length()<8;
			
			             Predicate<CreditCard> checkCreditLimit = (arg) -> 
			             arg.getCreditLimit() >400000;
			             
			if( checkNameLength.and(checkCreditLimit).test(card)) {
				System.out.println("Valid Customer ");
			} else {
				
				System.out.println("Invalid Customer ");
			}
			
		}
	
	
		// Using Primitive Predicate functional Interface 
				public void checkCardHolderName(Double amount) {
					
					
					CreditCard card = repo.findById(1022);
					
					double creditLimit = card.getCreditLimit();
					
					DoublePredicate checkLimit = (limit) -> limit ==amount;
					
					
					System.out.println("Is Eligible:="+checkLimit.test(creditLimit));
					
				}

		public void calculateMinimumAmount(Function<CreditCard,Double> calculate) {
			
			
					             
               Set<Map.Entry<Long, CreditCard>> list=     repo.findAll();

               
               for(Map.Entry<Long, CreditCard> eachCard : list) {
            	   
            	   CreditCard card = eachCard.getValue();
            	   
            	   System.out.println("Limit :="+calculate.apply(card));
            	   
               }
					             
		}
		
		public void calculateMinimumAmountAndCashLimit(Function<CreditCard,Double> calculateLimit,
				            Function<Double,Double> calculateCashLimit) { 
			
			
			   Set<Map.Entry<Long, CreditCard>> list=     repo.findAll();
			   
               for(Map.Entry<Long, CreditCard> eachCard : list) {

            	   CreditCard card = eachCard.getValue();

            	   calculateLimit.andThen(calculateCashLimit).apply(card);
            	   
            	   
               }
		}

}
