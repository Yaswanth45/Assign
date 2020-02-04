package com.cts.oopp.model;

public class Students extends Person {
	private int fee;
	public Students() {
		//Default Constructor
	}

	public Students(String name, int age,int fee) {
		super(name, age);
		this.fee=fee;
	}
	public void setFee(int fee) {
		this.fee=fee;
	}
	public int getFee() {
		return fee;
	}
	public String toString() {
		return super.toString()+"-"+fee;
	}

}
