package com.cts.oopp.model;

public abstract class Shape {
	protected double x;
	protected double y;
	public Shape() {
		x=0;
		y=0;
	}
	public Shape(double x) {
		this.x=x;
		this.y=x;
	}
	public Shape(double x, double y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public String toString() {
		return this.area()+" "+this.perimeter();
	}
	public abstract double area();
	public abstract double perimeter();
}
