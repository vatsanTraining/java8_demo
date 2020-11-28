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
		CheckEligibility.super.show(t);
	}

	@Override
	public double addEntity(String entity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
