package org.training.day.two.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import com.training.domains.CreditCard;
import com.training.repo.CreditCardRepository;

public class CreditCardService {

	
	private CreditCardRepository repo;
	private List<CreditCard> cardList ;

	public CreditCardService() {
		super();
       
		repo = new CreditCardRepository();
		
		 cardList = repo.getList();
	}
	
	
	// Using Stream - Filter Method
	
	
	public List<CreditCard> usingFilter(double amount){
		
		
		
		  
//		  List<CreditCard> filteredList = 
//				      this.cardList.stream().
//				            filter(element -> element.getCreditLimit()>300000 )
//				               .collect(Collectors.toList());	  
//			
	
				  
			    return   this.cardList.stream().
			            filter(element -> element.getCreditLimit()>amount )
			               .collect(toList());
		  
	}
	
	public List<String> usingMap(double amount){
		
		
		
		 
		 return   this.cardList.stream().filter(element -> element.getCreditLimit()>amount).
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
		
		

//		 return cardList.stream().
//				  sorted(Comparator.comparing(CreditCard::getCardHolder)).
//				       collect(toList());


		
		 return this.cardList.stream().
				  sorted(Comparator.comparing(CreditCard::getCardHolder).
						  thenComparing(Comparator.comparing(CreditCard::getCreditLimit))).
				       collect(toList());
		
	}
	
	public List<String> getDistinctCustomerName(){
		
		

		 return this.cardList.stream().map(element -> element.getCardHolder()).
				                distinct().collect(toList());
				 
		
		 
	}
	
	
	public Map<String,Double> transformListToMap(){
		
	

		 
		 return this.cardList.stream().filter(element -> element.getCreditLimit()>300000)
				                .collect(toMap(CreditCard::getCardHolder, 
				                		CreditCard::getCreditLimit));
				 
		
	}
	
	public Double[] aggregates() {
		
		Comparator<CreditCard> limitComparator = Comparator.comparing(CreditCard::getCreditLimit);
		
		
		Optional<CreditCard> maxLimit = this.cardList.stream().max(limitComparator);
		
		Optional<CreditCard> minLimit= this.cardList.stream().min(limitComparator);

		long sureshCount = this.cardList.stream().
				   filter(element -> element.getCardHolder().equalsIgnoreCase("Suresh")).count();
		
		double maxCredit =0.0;
		if(maxLimit.isPresent()) {
			
			 maxCredit = maxLimit.get().getCreditLimit();
		}
		double minCredit =0.0;

		if(minLimit.isPresent()) {
			 minCredit = minLimit.get().getCreditLimit();
		}
		
		return new Double[] {maxCredit,minCredit,new Double(sureshCount)};
	}

	
	public Map<String,List<CreditCard>> grouping(){
		
		
		return this.cardList.stream().collect(groupingBy(CreditCard::getCardProvider,toList()));
	}
	
}
