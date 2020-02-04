package com.cts.oopp.ui;

import com.cts.oopp.model.Emloyee;
import com.cts.oopp.model.Person;
import com.cts.oopp.model.Students;

public class InheritanceClient {

	public static void main(String[] args) {
		Person person=new Person();
		person.setName("Yaswanth");
		person.setAge(22);
		System.out.println(person);
		Emloyee emp=new Emloyee();
		emp.setName("Reddy");
		emp.setAge(22);
		emp.setSalary(350000);
		System.out.println(emp);
		Students std=new Students();
		std.setName("Yesh");
		std.setAge(22);
		std.setFee(25000);
		System.out.println(std);
	}

}
