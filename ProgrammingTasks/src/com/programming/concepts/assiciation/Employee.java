package com.programming.concepts.assiciation;

//Class 2
//Employee class
class Employee {
	// Attributes of employee
	private String name;
	// Employee name
	Employee(String name)
	{
		// This keyword refers to current instance itself
		this.name = name;
	}

	// Method of Employee class
	public String getEmployeeName()
	{
		// returning the name of employee
		return this.name;
	}
}
