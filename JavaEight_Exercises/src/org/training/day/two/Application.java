package org.training.day.two;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.training.day.two.services.CreditCardService;

import com.training.domains.CreditCard;

public class Application {

	public static void print(List<?> list) {
		
		list.forEach(System.out::println);
	}
	
public static void print(Map<String,Double> map) {
		

	Set<Map.Entry<String, Double>> data = map.entrySet();
	
	for(Map.Entry<String, Double> eachItem : data) {
		
		System.out.println(eachItem.getKey()   + eachItem.getValue());
	}
}
	
	public static void main(String[] args) {
	
		CreditCardService service = new CreditCardService();
		
		int key =2;
		
		switch (key) {
		case 1:
			List<CreditCard> cardList = service.usingFilter(300000);
			print(cardList);
			break;
		case 2:
			List<String> cardHolders = service.usingMap(300000);
			print(cardHolders);
			break;
		case 3:
			List<String> combinedList = service.usingFlatMap();
			print(combinedList);
			break;
		case 4:
			List<CreditCard> sortedList = service.sortedList();
			print(sortedList);
			break;
		case 5:
			List<String> distinctCardHolders = service.getDistinctCustomerName();
			print(distinctCardHolders);
			break;
		case 6:
			Map<String,Double> map = service.transformListToMap();
			print(map);
			break;
		case 7:
			Double[] aggregates = service.aggregates();
			
			System.out.println("Max Credit LImit :=" + aggregates[0]);
			System.out.println("MINIMUM Credit LImit:=" + aggregates[1]);
			System.out.println("CardsHolder With Name Suresh :=" + aggregates[2]);
			
			break;
		case 8:
			Map<String,List<CreditCard>> list = service.grouping();
			System.out.println("Visa Card Holders");
			 print(list.get("visa"));
			 System.out.println("Master Card Holders");
			 print(list.get("master"));
			break;
		default:
			break;
		}

	}

}
