package com.cenit.corejava.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex3 {
	private static List<String> strings = Arrays.asList("this", "is", "ab", "aa", "list", "of", "strings");

	public static void main(String[] args) {
		sort();
	}

	private static void sort() {

		List<String> sorted1 = strings.stream().sorted(Comparator.naturalOrder()).toList();

		System.out.println(sorted1);

		List<String> sorted2 = strings.stream()
				.sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
				.collect(Collectors.toList());

		System.out.println(sorted2);

	}

	private static void peekMethod() {

		IntStream.rangeClosed(0, 10).peek(n -> System.out.printf("original: %d%n", n)).map(n -> n * 2)
				.peek(n -> System.out.printf("doubled : %d%n", n)).filter(n -> n % 3 == 0)
				.peek(n -> System.out.printf("filtered: %d%n", n)).sum();
	}

}
