package com.cts.oopp.model;

public class Emloyee extends Person {
	private int salary;
	public Emloyee() {
		/* default Constructor */
	}

	public Emloyee(String name, int age,int salary) {
		super(name, age);
		this.salary=salary;
	}
	public void setSalary(int salary) {
		this.salary=salary;
	}
	public int getSalary() {
		return salary;
	}
	public String toString() {
		return super.toString()+","+salary;
	}

}
