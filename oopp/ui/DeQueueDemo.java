package com.cts.oopp.ui;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DeQueueDemo {

	public static void main(String[] args) {
		
		// Queue<String> q = new LinkedList<String>();
		Deque<String> q = new LinkedList<String>();
		    
	      
	      q.add("Rick");
	      q.add("Maggie"); 
	      q.add("Glenn");
	      q.add("Negan");
	      q.add("Daryl");
	      
	      System.out.println("Elements in Queue:"+q);
	      System.out.println("Removed element: "+q.remove());
	      System.out.println("Head: "+q.element());
	      System.out.println("poll(): "+q.poll());
	      System.out.println("peek(): "+q.peek());
	      System.out.println("Elements in Queue:"+q);

	}

}
