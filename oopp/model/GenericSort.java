package com.cts.oopp.model;

public class GenericSort implements ISort {

	@Override
	public void sortData(int[] a) {
		int i,j,temp;
		for(i=0;i<a.length;i++) {
			for(j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}

	}

}
