package com.cts.CD.ui;

import java.util.Set;
import java.util.TreeSet;

import com.cts.CD.model.Person;

public class App {

	public static void main(String[] args) {
		Set<Person> persons=new TreeSet<>();
		persons.add(new Person("Yaswanth",22));
		persons.add(new Person("Murali",22));
		persons.add(new Person("Rohit",32));
		persons.add(new Person("Virat",31));
		persons.add(new Person("Yaswanth",24));
		for(Person person:persons) {
			System.out.println(person);
		}
//		Person p1=new Person("Rohit",32);
//		Person p2=new Person("Rohit",32);
//		System.out.println(p1.hashCode()+" "+p2.hashCode());

	}

}
