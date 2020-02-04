package com.cts.EP.ui;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cts.EP.model.Employee2;

public class Employee2Demo {

	public static void main(String[] args) throws IOException {
		try {
			FileOutputStream out=new FileOutputStream("output.txt");
			
			
			List<Employee2> pq = new ArrayList<Employee2>();
			
			
		}catch(DateTimeException exep) {
			exep.printStackTrace();
		}
		 
//		String line=br.readLine(); 
//		while (line != null) {
//		    System.out.println(line); 
//		    line=br.readLine();
//		} 
//		br.close();
		
}
}