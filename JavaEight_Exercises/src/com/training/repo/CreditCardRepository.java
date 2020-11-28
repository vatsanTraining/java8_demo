package com.training.repo;

import java.util.*;

import com.training.domains.CreditCard;
public class CreditCardRepository {

	
	private HashMap<Long, CreditCard> cards;

	private ArrayList<CreditCard> list;
	
	public CreditCardRepository() {
		super();

		cards =new HashMap<>();
		
		cards.put(1020L,
				new CreditCard(1020,"Manish", 50000));
		cards.put(1021L,new CreditCard(1021,"Sachin", 450000));
		cards.put(1022L,new CreditCard(1022,"Vikas",  1450000));
		cards.put(1023L,new CreditCard(1023,"Suresh", 250000));
		cards.put(1024L,new CreditCard(1024,"Ashish", 350000));

	
		list = new ArrayList<CreditCard>();
		
		list.add(new CreditCard(1020,"Manish Shetty", 50000));
		list.add(new CreditCard(1020,"Sachin", 450000));
		list.add(new CreditCard(1020,"Vikas", 1450000));
		list.add(new CreditCard(1020,"Suresh", 250000));
		list.add(new CreditCard(1020,"Ashish Kumar", 350000));
		
	}
	
	
	

	public ArrayList<CreditCard> getList() {
		return list;
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
