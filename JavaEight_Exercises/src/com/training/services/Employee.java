package com.training.services;

import com.training.ifaces.CheckEligibility;
import com.training.ifaces.ChekStatus;

import lombok.Data;

@Data
public class Employee implements CheckEligibility<Employee>,ChekStatus<Employee> {

	private String grade;
	
	@Override
	public boolean test(Employee other) {
		return this.grade.equals(other.grade);
	}

	@Override
	public void show(Employee t) {
		// TODO Auto-generated method stub
		ChekStatus.super.show(t);
	}

	@Override
	public double addEntity(String entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getMessage() {
		
		switch (this.grade) {
		case "Manager":
				return "Great Manager";
		case "Leader":
			return "Excellent Leader";
		default:
			return null;
		}
	}
}
