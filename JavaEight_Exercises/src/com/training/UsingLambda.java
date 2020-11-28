package com.training;

import java.util.function.Function;

import com.training.domains.CreditCard;
import com.training.services.CreditCardService;

public class UsingLambda {

	public static void main(String[] args) {

		
		CreditCardService service =new CreditCardService();
		
		  service.display();
		  
		  System.out.println("Customer Eligibile Housing Loan");
		  
		  service.checkForLoanEligibility();
		  
		  
		  service.checkCardHolderName();
		  
		  service.checkCardHolderName(1022);
		  
		  service.checkCardHolderName(1023);
		  
		  service.checkCardHolderName(1450000.00);
		  
			Function<CreditCard, Double> calculateLimit = 
					
		             (card) -> card.getCreditLimit() *.05;

		  
		  service.calculateMinimumAmount(calculateLimit);
		  
		  Function<Double, Double> calculateCashLimit = 
					
		             (amount) -> amount *.10;
		             

		      service.calculateMinimumAmountAndCashLimit(calculateLimit, calculateCashLimit);       
	}

}
