package com.cenit.corejava.java8.general;

public class Ex2 {

	public static void main(String[] args) {
		int n = 1634;
		int sum = 0;
		int count = 0;
		int sNum = n;
		while(n>0) {
			count++;
			n = n/10;
		}
		n = sNum;
		while (n > 0) {
			
			sum += Math.pow( n%10 , count);
			n = n/10;
		}
		
		System.out.println(sum);
		if (sum == sNum)
			System.out.println("it is a armstrong number");
		else
			System.out.println("it is not a armstrong number");
	}

}
