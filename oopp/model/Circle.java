package com.cts.oopp.model;

public class Circle extends Shape {

	public Circle() {
		super();
	}

	public Circle(double x) {
		super(x);
	}

	public Circle(double x, double y) {
		super(x, y);
	}

	@Override
	public double area() {
		return Math.PI*Math.pow(x, 2);
	}

	@Override
	public double perimeter() {
		return 2*Math.PI;
	}

}
