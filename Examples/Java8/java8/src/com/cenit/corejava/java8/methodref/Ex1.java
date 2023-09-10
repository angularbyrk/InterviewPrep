package com.cenit.corejava.java8.methodref;

import java.util.stream.Stream;

public class Ex1 {

	public static void main(String[] args) {

		Stream.of(3, 1, 4, 1, 5, 9).forEach(System.out::println);

	}

}
