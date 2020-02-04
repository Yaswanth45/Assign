package com.cts.CD.ui;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class MenuDriven {

	public static void main(String[] args) {
		ArrayList<String> players=new ArrayList<String>();
		players.add("Yaswanth");
		players.add("Rohit");
		int choice=0;
		do {
			System.out.println("\nArrayList operations Demo");
			System.out.println("0:Display\n 1.Add Players\n 2.Remove Players\n 3.Change Player\n 4.exit");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			choice=Integer.parseInt(br.readLine());
			String name;
			int position;
			switch(choice) {
					case 0:		System.out.println("Players currently in the ArrayList");
								Iterator<String> it=players.iterator();
								while(it.hasNext()) {
									System.out.println(it.next()+" ");
								}
								break;
					case 1:		System.out.println("Enter the players ");
								name=br.readLine();
								System.out.println("Enter the position in the List");
								position=Integer.parseInt(br.readLine());
								players.add(position-1,name);
								break;
					case 2:		System.out.println("Enter Player to remove");
								name=br.readLine();
								players.remove(position-2,name);
								break;
					case 3:		System.out.println("Enter the position in the List");
								position=Integer.parseInt(br.readLine());
								System.out.println("Enter Player Name");
								name=br.readLine();
								players.set(position-1, name);
								break;
					default :	System.out.println("Exit the program");
			}
		}while(choice <4 && choice>=0);

	}

}
