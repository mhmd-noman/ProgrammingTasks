package com.programming.concepts.assiciation;
//Java Program to illustrate the
//Concept of Association

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//Class 1
//Bank class
class Bank {

	// Attributes of bank
	private String name;

	private Set<Employee> employees;
	// Constructor of this class
	Bank(String name)
	{
		// this keyword refers to current instance itself
		this.name = name;
	}

	// Method of Bank class
	public String getBankName()
	{
		// Returning name of bank
		return this.name;
	}

	public void setEmployees(Set<Employee> employees){
		this.employees = employees;
	}
	public List<Employee> getEmployees(){
		return new ArrayList<>(this.employees);
	}
}
