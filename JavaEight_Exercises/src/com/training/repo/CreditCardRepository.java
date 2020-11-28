package com.training.repo;

import java.util.*;

import com.training.domains.CreditCard;
public class CreditCardRepository {

	
	private HashMap<Long, CreditCard> cards;

	public CreditCardRepository() {
		super();

		cards.put(1020L,new CreditCard(1020,"Manish", 50000));
		cards.put(1021L,new CreditCard(1021,"Sachin", 450000));
		cards.put(1022L,new CreditCard(1022,"Vikas",  1450000));
		cards.put(1023L,new CreditCard(1023,"Suresh", 250000));
		cards.put(1024L,new CreditCard(1024,"Ashish", 350000));

		
	}
	
	
	public boolean addCard(CreditCard card) {
	
		boolean result = false;
		
		 CreditCard response =(CreditCard)cards.put(card.getCardNumber(),card);
		 
		 if(response==null) {
			 result = true;
		 }
		 
		 return result;
	}
	
	public Set<Map.Entry<Long,CreditCard>> findAll(){
	
		 Set<Map.Entry<Long, CreditCard>> list = this.cards.entrySet();
		 
		 return list;
	}
	
	public CreditCard findById(long key) {
		
		return cards.get(key);
	}
	
}
