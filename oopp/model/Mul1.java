package com.cts.oopp.model;

public class Mul1 implements IMul {

	@Override
	public void MultiPly(int[][] a, int[][] b, int [][]c) {
		int n=a.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				c[i][j]=0;
				for(int k=0;k<n;k++) {
					c[i][j]+=a[i][k]*b[k][j];
				}
			}
		}

	}

	@Override
	public void Addition(int[][] a, int[][] b, int [][]c) {
		int n=a.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
					c[i][j]=a[i][j]+b[i][j];
				}
			}

	}

	@Override
	public void Show(int[][] c) {
		int n=c.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
