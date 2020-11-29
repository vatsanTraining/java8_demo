package org.training.day.two.services;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;

import static java.util.stream.Collectors.*;

import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
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
		
		
		Optional<String> firstIntheList =   this.cardList.stream().filter(element -> element.getCreditLimit()>amount).
           map(element -> element.getCardHolder()).findFirst();

		 System.out.println("First in the List:="+firstIntheList.get());
		 
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
		
		// Using Tree Set to eliminate duplicates
		TreeSet<String> linkedList =this.cardList.stream()
				 .map(element -> element.getCardHolder()).
                      collect(toCollection(TreeSet<String>::new));

		System.out.println("Collected to TreeSet");
		linkedList.forEach(System.out::println);
		System.out.println("==============");
		
		
		// Using Distinct to achieve the same
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
	
	
	public double findMaxCreditLimit() {
		
		  Optional<Double> maxLimit= this.cardList.parallelStream()
				             .map(element ->element.getCreditLimit())
				                 .reduce((e1,e2)-> e1>e2?e1:e2);
		
		return maxLimit.get();
	}
	
	public void printCardExpiryDate() {
		
		
	List<LocalDate> dateList=	this.cardList.stream().map(element -> element.getCardExpiryDate()).collect(toList());
	
	    for(LocalDate date : dateList) {
	    	
	    	System.out.println("IssueDate: = " +date.minus(3,ChronoUnit.YEARS) +  "Expiry Date :="+date);
	    	
	    	Period period = Period.between(LocalDate.now(),date);
	    	
	    	System.out.println(period);
	    	
	    	System.out.println(period.get(ChronoUnit.YEARS));
	    }
	
	}
}
