package com.cenit.corejava.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * object::instanceMethod
		Refer to an instance method using a reference to the supplied object, as in
		System.out::println
	Class::staticMethod
		Refer to static method, as in Math::max
	Class::instanceMethod
		Invoke the instance method on a reference to an object supplied by the context,as in String::length
 */

public class Ex2 {

	public static void main(String[] args) {

		Stream.of(3, 1, 4, 1, 5, 9).forEach(System.out::println);

		Consumer<Integer> printer = System.out::println;

		Stream.of(3, 1, 4, 1, 5, 9).forEach(printer);

		List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

		List<String> sorted = strings.stream().sorted(String::compareTo).collect(Collectors.toList());

	}

}
