package org.training.day.two;

import java.util.List;

import org.training.day.two.services.CreditCardService;

import com.training.domains.CreditCard;

public class Application {

	public static void print(List<?> list) {
		
		list.forEach(System.out::println);
	}
	public static void main(String[] args) {
	
		CreditCardService service = new CreditCardService();
		
		int key =3;
		
		switch (key) {
		case 1:
			List<CreditCard> cardList = service.usingFilter(300000);
			print(cardList);
			break;
		case 2:
			List<String> cardHolders = service.usingMap(300000);
			print(cardHolders);
		case 3:
			List<String> combinedList = service.usingFlatMap();
			print(combinedList);
		default:
			break;
		}

	}

}
