package com.cts.EP.ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EmployeeDemo {

	public static void main(String[] args) throws IOException {
	     FileOutputStream out = null;
	     try {
	    	 out=new FileOutputStream("output.txt");
	    	 
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
	}

}
