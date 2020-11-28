package com.training;

import java.util.Optional;

import com.training.services.CrediCardServiceWithMethodReference;
import com.training.services.Employee;

public class UsingMethoReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		CrediCardServiceWithMethodReference ref = 
				
				 new CrediCardServiceWithMethodReference();
		
		ref.showAll();
		
		ref.checkName();
				 
		Employee ram = new Employee();
		  ram.setGrade("Manager");
		  
		  Employee shyam = new Employee();
		  shyam.setGrade("Leader");
		  
		  System.out.println(ram.test(shyam));
		  
		  ram.show(shyam);
		  
		  Optional<String> option = Optional.ofNullable(ram.getMessage());
		  
		 if( option.isPresent()){
			  System.out.println("Optional Get :" +option.get());
			     
		  } else {
			   System.out.println("Invalid Choice - ");
		  }

		   option.ifPresent(arg -> System.out.println("if Present"+arg));
		   
		   
		   
	}

}
