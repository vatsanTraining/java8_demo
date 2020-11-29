package org.training.day.two.services;

import java.util.List;
import static java.util.stream.Collectors.*;
import com.training.domains.CreditCard;
import com.training.repo.CreditCardRepository;

public class CreditCardService {

	
	private CreditCardRepository repo;

	public CreditCardService() {
		super();
       
		repo = new CreditCardRepository();
	}
	
	
	// Using Stream - Filter Method
	
	
	public List<CreditCard> usingFilter(){
		
		
		  List<CreditCard> cardList = repo.getList();
		  
//		  List<CreditCard> filteredList = 
//				      cardList.stream().
//				            filter(element -> element.getCreditLimit()>300000 )
//				               .collect(Collectors.toList());	  
//			
	
				  
			    return   cardList.stream().
			            filter(element -> element.getCreditLimit()>300000 )
			               .collect(toList());
		  
	}
	
	
}
