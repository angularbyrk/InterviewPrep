package com.cenit.corejava.java8.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex6 {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "s1", 1000);
		Employee e2 = new Employee(2, "s2", 2000);
		Employee e3 = new Employee(3, "s3", 3000);
		Stream.of(e1, e2, e3).toList();
		Stream.of(e1, e2, e3).collect(Collectors.toSet());
		Stream.of(e1, e2, e3).collect(Collectors.toMap(Employee::getId, e -> e));

	}
}
