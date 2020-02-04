package com.cts.CD.ui;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class QueueDemo {

	public static void main(String[] args) {
		 Queue<String> pq=new PriorityQueue<String>();
	      int ch;
	      String e;
	      Scanner sc=new Scanner(System.in);
	      System.out.println("1:ADD");
	      System.out.println("2:REMOVE");
	      System.out.println("3:PEEK");
	      System.out.println("4:POLL");
	      System.out.println("5:ITERATOR");
	      System.out.println("enter your Choice");
	      ch=sc.nextInt();
	      switch(ch)
	      {
	          case 1:System.out.println("enter ele to add");
	                 e=sc.nextLine();
	                 pq.add(e);
	                 System.out.println("element added is"+e);
	                 break;
	         case 2:System.out.println("enter ele to remove");
	                 e=sc.nextLine();
	                 pq.remove(e);
	                 break;
	         case 3:System.out.println("enter element to retrive");
	                 e=sc.next();
	                 pq.peek();
	                 break;
	         case 4:System.out.println("enter ele to remove");
	                 e=sc.next();
	                 pq.poll();
	                 System.out.println("top priority ele is deleted");
	                 break;
	         case 5:System.out.println("traverse the list");
	                 Iterator it=pq.iterator();
	                 while(it.hasNext())
	                 System.out.println(it.next());
	                 break;
	         default:System.exit(0);
	            }
	    }
	}
