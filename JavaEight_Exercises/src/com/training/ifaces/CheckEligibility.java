package com.training.ifaces;

@FunctionalInterface
public interface CheckEligibility<T> {

	public boolean test(T t);
	
	
	default void show(T t) {
		
		System.out.println(t);
	}
}
