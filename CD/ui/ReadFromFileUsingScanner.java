package com.cts.CD.ui;
	import java.io.File;
	import java.util.Scanner;

	public class ReadFromFileUsingScanner {
		public static void main(String[]args) throws Exception {
			File file=new File("D:\\nonblank.txt");
			
			Scanner sc=new Scanner(file);
			while(sc.hasNextLine())
				System.out.println(sc.nextLine());
			sc.close();
			
		}

	}
 


