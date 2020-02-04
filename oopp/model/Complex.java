package com.cts.oopp.model;

public class Complex {
	private int realPart;
	private int imaginaryPart;
	public Complex() {
		realPart=0;
		imaginaryPart=0;
	}
	public Complex(int realPart,int imaginaryPart) {
		this.realPart=realPart;
		this.imaginaryPart=imaginaryPart;
	}
	public void setRealPart(int realPart) {
		this.realPart=realPart;
	}
	public int getRealPart() {
		return this.realPart;
	}
	public void setImaginaryPart(int imaginaryPart) {
		this.imaginaryPart=imaginaryPart;
	}
	public int getImaginaryPart() {
		return this.imaginaryPart;
	}
	public Complex add(Complex s) {
		int realPartSum=this.getRealPart()+s.getRealPart();
		int imaginaryPartSum=this.getImaginaryPart()+s.getImaginaryPart();
		Complex t=new Complex(realPartSum,imaginaryPartSum);
		return t;
	}
	public void show() {
		System.out.println(realPart+","+imaginaryPart);
	}
}
