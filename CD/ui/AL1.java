package com.cts.CD.ui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AL1 {

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		List<String> names=new ArrayList<>();
		String name=null;
		while(true) {
			System.out.println("Enter name");
			name=ob.nextLine();
			if(name.equals("end"))
				break;
			names.add(name);
		}
		for(String data:names) {
			System.out.println(data);
		}
		List<String> names1=new LinkedList<>();
		while(true) {
			System.out.println("Enter name");
			name=ob.nextLine();
			if(name.equals("end"))
				break;
			names1.add(name);
		}
		for(String data:names1) {
			System.out.println(data);
		}
	}

}
