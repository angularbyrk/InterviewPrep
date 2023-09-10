package com.cenit.corejava.java8.general;

public class Ex1 {

	public static void main(String[] args) {
		int n = 8128;
		int sum = 0;
		int i = 1;
		while (i <= n / 2) {
			if (n % i == 0) {
				sum = sum + i;
			}
			i++;
		}
		System.out.println(sum);
		if (sum == n)
			System.out.println("it is a perfect number");
		else
			System.out.println("it is not a perfect number");
	}

}
