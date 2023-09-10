package com.cenit.corejava.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex4 {
	private static List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

	public static void main(String[] args) {
		Map<Boolean, Long> numberLengthMap = strings.stream()
				.collect(Collectors.partitioningBy(s -> s.length() % 2 == 0, Collectors.counting()));
		System.out.println(numberLengthMap);
	}

}
