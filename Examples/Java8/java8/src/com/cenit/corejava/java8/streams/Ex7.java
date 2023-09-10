package com.cenit.corejava.java8.streams;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex7 {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "s1", 1000, "dep1");
		Employee e2 = new Employee(2, "s2", 2000, "dep2");
		Employee e3 = new Employee(3, "s3", 3000, "dep3");
		Employee e4 = new Employee(4, "s4", 4000, "dep1");
		Employee e5 = new Employee(5, "s5", 5000, "dep2");
		Optional<Employee> optionalEmp1 = Stream.of(e1, e2, e3, e4, e5)
				.reduce(BinaryOperator.maxBy(Comparator.comparingInt(Employee::getSal)));

		Optional<Employee> optionalEmp2 = Stream.of(e1, e2, e3, e4, e5).max(Comparator.comparingInt(Employee::getSal));

		Stream.of(e1, e2, e3, e4, e5).collect(
				Collectors.groupingBy(e->e.getDept(), Collectors.maxBy(Comparator.comparing(Employee::getSal))));

		Stream.of(e1, e2, e3, e4, e5).collect(
				Collectors.groupingBy(e->e.getDept(), Collectors.averagingDouble(Employee::getSal)));

	}
}
