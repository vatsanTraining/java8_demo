package com.training;

public class Application {

	public static void main(String[] args) {

		// BEFORE JAVA 8	
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {

				for(int i=0;i<=10;i++) {
					System.out.println(i);
				}
			}
		};
		
		Thread thread1 = new Thread(runnable);
		
		 thread1.start();
		 
		 
		 // from java 8
		 
		 
		 Thread thread2 = new Thread( () ->  {
			 
			 for(int i=0;i<=10;i++) {
				 System.out.println(i);
			 }
		 });
		
		 thread2.start();
		 
		 Runnable runnable2 = () -> { for(int i=0;i<5;i++) {System.out.println(i*i);}};
		 
		 Thread thread3 = new Thread(runnable2);
		 thread3.start();
		 
		 System.out.println(runnable2);
	}

}
