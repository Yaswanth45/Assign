package com.cts.oopp.ui;

import java.util.Random;
import java.util.Scanner;

import com.cts.oopp.model.BubbleSort;
import com.cts.oopp.model.GenericSort;
import com.cts.oopp.model.ISort;

public class InterfaceClient {

	public static void main(String[] args) {
		int [] a=new int[10];
		Random random=new Random();
		for(int i=0;i<10;i++) {
			a[i]=random.nextInt(1000);
		}
		for(int i=0;i<10;i++) {
			System.out.println(a[i]);
		}
		System.out.println("Sorted Data------------------------");
		System.out.println("Enter ur Choice\n 1.GenericSort\n 2.BubbleSort");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ISort sort;
		switch(n) {
			case 1:
					sort=new GenericSort();
					sort.sortData(a);
					break;
			case 2:
					sort=new BubbleSort();
					sort.sortData(a);
					break;
			default:
					System.out.println("Nothing given");
					break;
		}
		for(int value:a) {
			System.out.println(value);
		}
	}

}
