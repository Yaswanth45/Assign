package com.cts.oopp.ui;

import com.cts.oopp.model.Circle;
import com.cts.oopp.model.Rectangle;
import com.cts.oopp.model.Shape;

public class AbstractClient {

	public static void main(String[] args) {
//		Rectangle rect=new Rectangle(10,5);
//		System.out.println(rect);
//		Circle cir=new Circle(3);
//		System.out.println(cir);
		
		//Polymorphism
		Shape shape;
		shape=new Rectangle(10,5);
		System.out.println(shape);
		shape=new Circle(3);
		System.out.println(shape);
	}

}
