package com.cts.oopp.ui;
import java.util.Scanner;
class MatrixMul{
	public static void main(String [] args){
		Scanner ob=new Scanner(System.in);
		System.out.println("Enter the no of elements");
		int n=ob.nextInt();
		int a[][]=new int[n][n];
		int b[][]=new int[n][n];
		int c[][]=new int[n][n];
		System.out.println("First Matrix ele");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				a[i][j]=ob.nextInt();
			}
		}
		System.out.println("Second Matrix ele");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				b[i][j]=ob.nextInt();
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				c[i][j]=0;
				for(int k=0;k<i;k++){
					c[i][j]=c[i][j]+a[i][k]*b[k][j];
				}
			}
		}
		System.out.println("Final Matrix");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
}