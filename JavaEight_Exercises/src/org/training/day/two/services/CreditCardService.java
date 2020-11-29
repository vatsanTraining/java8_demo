package org.training.day.two.services;

import java.util.List;
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Comparator;

import com.training.domains.CreditCard;
import com.training.repo.CreditCardRepository;

public class CreditCardService {

	
	private CreditCardRepository repo;

	public CreditCardService() {
		super();
       
		repo = new CreditCardRepository();
	}
	
	
	// Using Stream - Filter Method
	
	
	public List<CreditCard> usingFilter(double amount){
		
		
		  List<CreditCard> cardList = repo.getList();
		  
//		  List<CreditCard> filteredList = 
//				      cardList.stream().
//				            filter(element -> element.getCreditLimit()>300000 )
//				               .collect(Collectors.toList());	  
//			
	
				  
			    return   cardList.stream().
			            filter(element -> element.getCreditLimit()>amount )
			               .collect(toList());
		  
	}
	
	public List<String> usingMap(double amount){
		
		
		 List<CreditCard> cardList = repo.getList();
		 
		 
		 return   cardList.stream().filter(element -> element.getCreditLimit()>amount).
		            peek((element) ->System.out.println("Element"+element)).map(element -> element.getCardHolder()).collect(toList());
		
	}
	
	public List<String> usingFlatMap(){
		
		List<String> list1 = usingMap(300000);
		List<String>  list2 =usingMap(50000);
		
		List<List<String>> listOfList = Arrays.asList(list1,list2);
		
		
//		return listOfList.stream().flatMap(element -> element.stream()).limit(4).collect(toList());
		
		return listOfList.stream().flatMap(element -> element.stream()).skip(4).collect(toList());
	}
	
	public List<CreditCard> sortedList(){
		
		 List<CreditCard> cardList = repo.getList();

		 return cardList.stream().
				  sorted(Comparator.comparing(CreditCard::getCardHolder)).
				       collect(toList());
		 
		
	}
}
