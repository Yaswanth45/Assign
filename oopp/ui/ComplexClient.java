package com.cts.oopp.ui;

import com.cts.oopp.model.Complex;

public class ComplexClient {

	public static void main(String[] args) {
		Complex first=new Complex();
		first.show();
		Complex second=new Complex(2,-5);
		second.show();
		if(first==second)
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		if(first.getRealPart()==second.getRealPart() && first.getImaginaryPart()==second.getImaginaryPart())
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		Complex result=first.add(second);
		result.show();
		Complex third=second;
		third.show();
		if(second==third)
			System.out.println("Second and third are Equal");
		else
			System.out.println("Second and third are not equal");
	}

}
