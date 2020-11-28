package com.training;

import com.training.services.CrediCardServiceWithMethodReference;

public class UsingMethoReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		CrediCardServiceWithMethodReference ref = 
				
				 new CrediCardServiceWithMethodReference();
		
		ref.showAll();
		
		ref.checkName();
				 
	}

}
