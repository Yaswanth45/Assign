package com.cts.CD.services;

import java.util.Comparator;

import com.cts.CD.model.Employee;

public class EmployeeBirthDateComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee first, Employee other) {
		return first.getBirthDate().compareTo(other.getBirthDate());
	}

}
