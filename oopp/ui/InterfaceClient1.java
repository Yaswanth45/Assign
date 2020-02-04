package com.cts.oopp.ui;

import java.util.Scanner;

import com.cts.oopp.model.IMul;
import com.cts.oopp.model.Mul1;

public class InterfaceClient1 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the size :");
		int n=sc.nextInt();
		int [][]a=new int[n][n];
		int [][]b=new int[n][n];
		int [][]c=new int[n][n];
		System.out.println("Enter first array Elements");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter Second array Elements");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				b[i][j]=sc.nextInt();
			}
		}
		IMul mul;
		mul=new Mul1();
		System.out.println("Enter your choice\n 1.Multiply\n 2.Addition\n 3.Display");
		int ch=sc.nextInt();
		System.out.println("================Output==================");
//		while(ch<4&&ch>1) {
//			switch(ch) {
//				case 1:		mul.MultiPly(a, b, c);
//							break;
//				case 2:		mul.Addition(a, b, c);
//							break;
//				case 3:		mul.Show(c);
//							break;
//				default:	System.out.println("No data given");
//							break;
//					
//			}
//		}
		mul.MultiPly(a, b, c);
		mul.Show(c);
		mul.Addition(a, b, c);
		mul.Show(c);
	}
}
