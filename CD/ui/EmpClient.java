package com.cts.CD.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cts.CD.model.Employee;
import com.cts.CD.services.EmployeeBirthDateComparator;
import com.cts.CD.services.NameComparator;

public class EmpClient {

	public static void main(String[] args) {
		List<Employee> emp=new ArrayList<>();
		emp.add(new Employee(1,"Yaswanth",LocalDate.of(1998, 1, 24), 350000));
		emp.add(new Employee(2,"Murali",LocalDate.of(1998, 11, 18), 300000));
		emp.add(new Employee(3,"Rohit",LocalDate.of(1982, 4, 30), 8550000));
		emp.add(new Employee(4,"Virat",LocalDate.of(1983, 6, 12), 11500000));
		emp.add(new Employee(5,"Dhoni",LocalDate.of(1975, 10, 7), 1350000));

		Collections.sort(emp);
		for(Employee employee : emp) {
			System.out.println(employee);
		}
		System.out.println("---------------------------------------");

		Collections.sort(emp, new NameComparator());
		for(Employee employee : emp) {
			System.out.println(employee);
		}
		System.out.println("---------------------------------------");


		Collections.sort(emp, new EmployeeBirthDateComparator());
		for(Employee employee : emp) {
			System.out.println(employee);
		}
		System.out.println("---------------------------------------");

	}

}
