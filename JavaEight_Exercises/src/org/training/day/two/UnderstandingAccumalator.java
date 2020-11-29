package org.training.day.two;
import java.util.*;
public class UnderstandingAccumalator {

	public static void main(String[] args) {
		
List<Long> marks = Arrays.asList(1L,2L,3L);
	    Long result =  marks.parallelStream().reduce(3L, Long::sum);
System.out.println(result);              // 15


       long initial = 3L;
	    long sum =0L;
	    long finalTotal = 0L;
	    for(Long eachNumber : marks){      
	    	System.out.println("SUM -STEP -:1 :="+sum);
	    	sum =sum +eachNumber ; 
	    	System.out.println("SUM STEP-2:="+sum);
	    	sum = sum + initial;
	    	System.out.println("SUM After STEP-Added With Initial value =>3 :="+sum);
	    	finalTotal = sum;            
            System.out.println("Result :="+finalTotal);
	    }
	    System.out.println(finalTotal);            // 15
}


	

}
