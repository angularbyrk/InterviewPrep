package java_temp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee {
	private String name;
	private Integer salary;
	private String department;

	public Employee(String name, Integer salary, String department) {
		super();
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}

public class Ex5 {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Cersei", 40, "Lannister"),
				new Employee("Jamie", 10, "Lannister"), new Employee("Tyrion", 30, "Lannister"),
				new Employee("Tywin", 20, "Lannister"), new Employee("Jon Snow", 1, "Stark"),
				new Employee("Robb", 3, "Stark"), new Employee("Eddard", 2, "Stark"), new Employee("Sansa", 4, "Stark"),
				new Employee("Arya", 5, "Stark"));

		Map<String, Double> values = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));

		Map<Object, Object> values2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment))
				.entrySet().stream()
				.collect(Collectors.toMap(entry -> entry.getKey(),
						entry -> entry.getValue().stream().map(e -> e.getSalary()).reduce(0, (x, y) -> x + y)
								/ entry.getValue().size()));

		Map<Object, Object> values3 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment))
				.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()
						.stream().max(Comparator.comparing(Employee::getSalary))));

		values3.forEach((k, v) -> {
			System.out.println(k + "-" + v);
		});

	}

}
