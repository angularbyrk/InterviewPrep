package com.cenit.corejava.java8.streams;

import java.util.Arrays;
import java.util.List;

public class Ex8 {

	public static void main(String[] args) {

		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 89, 102, 98, 98, 32, 15);

		myList.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

		myList.stream().map(x -> {
			try {
				return x / 0;
			} catch (Exception e) {
				throw e;
			}
		}).forEach(System.out::println);

		myList.stream().sorted();
		
	}
}
