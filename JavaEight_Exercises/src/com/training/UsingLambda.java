package com.training;

import com.training.services.CreditCardService;

public class UsingLambda {

	public static void main(String[] args) {

		
		CreditCardService service =new CreditCardService();
		
		  service.display();
		  
		  System.out.println("Customer Eligibile Housing Loan");
		  
		  service.checkForLoanEligibility();
	}

}
