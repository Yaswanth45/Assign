package com.cts.CD.ui;

import java.util.ArrayList;
import java.util.Collections;

public class CollectDemo {

	public static void main(String[] args) {
		ArrayList<String> names=new ArrayList<>();
		names.add("James Gosling");
		names.add("Allen Cooper");
		names.add("Yaswanth");
		names.add("Dennis Ritchee");
		Collections.sort(names);
		PrintList(names);
		System.out.println("--------------------");
		int pos=Collections.binarySearch(names,"Allen Cooper");
		System.out.println("Position is"+" "+pos);
		System.out.printf("Maximum is %s\n",Collections.max(names));
		System.out.println("----------------------");
		Collections.reverse(names);
		PrintList(names);
	}

	private static void PrintList(ArrayList<String> names) {
		for(String name:names) {
			System.out.println(name);;
		}
		
	}

}
