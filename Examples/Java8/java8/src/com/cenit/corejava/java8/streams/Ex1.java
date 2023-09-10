package com.cenit.corejava.java8.streams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
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

public class Ex1 {

	public static void main(String[] args) {
		sumOfInt();
		sumOfObjects();
		otherOperations();
	}

	private static void sumOfInt() {
		int tSum = Stream.of(1, 2, 3, 4, 5).reduce(0, (sum, x) -> sum + x);
		System.out.println(tSum);
	}

	private static void sumOfObjects() {

		Employee e1 = new Employee(1, "s1", 1000);
		Employee e2 = new Employee(2, "s2", 2000);
		Employee e3 = new Employee(3, "s3", 3000);
		int tSum = Stream.of(e1, e2, e3).map(Employee::getSal).reduce(0, (sum, x) -> sum + x);
		System.out.println(tSum);
	}

	private static void otherOperations() {
		Employee e1 = new Employee(1, "s1", 1000);
		Employee e2 = new Employee(2, "s2", 2000);
		Employee e3 = new Employee(3, "s3", 3000);
		OptionalDouble avg = Stream.of(e1, e2, e3).mapToInt(Employee::getSal).average();
		OptionalInt max = Stream.of(e1, e2, e3).mapToInt(Employee::getSal).max();
		OptionalInt min = Stream.of(e1, e2, e3).mapToInt(Employee::getSal).min();
		System.out.println(avg.getAsDouble());
		System.out.println(max.getAsInt());
		System.out.println(min.getAsInt());
	}
}
