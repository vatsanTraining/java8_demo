package com.training.ifaces;

public interface ChekStatus<T> {

	public double addEntity(String entity);
	
default void show(T t) {
		
		System.out.println(t);
	}
}
