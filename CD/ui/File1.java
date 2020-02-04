package com.cts.CD.ui;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class File1 {

	public static void main(String[] args) {
		try {
			Scanner ob=new Scanner(System.in);
			System.out.println("Enter Filename :");
			String fileName=ob.nextLine();
			FileReader fr=new FileReader(fileName);
			int ch;
			while(true) {
				ch=fr.read();
				if(ch==-1)
					break;
				System.out.println((char)ch);
			}
		}catch(FileNotFoundException excp) {
			System.out.println("No such file Present");
		}catch(IOException excp) {
			System.out.println("could not read file");
		}

	}

}
