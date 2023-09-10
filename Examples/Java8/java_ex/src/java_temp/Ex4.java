package java_temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Customer {
	private String name;
	private List<Order> orders = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public Customer addOrder(Order order) {
		orders.add(order);
		return this;
	}
}

class Order {
	private int id;

	public Order(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

public class Ex4 {

	public static void main(String[] args) {
		Customer sheridan = new Customer("Sheridan");
		Customer ivanova = new Customer("Ivanova");
		Customer garibaldi = new Customer("Garibaldi");
		sheridan.addOrder(new Order(1)).addOrder(new Order(2)).addOrder(new Order(3));
		ivanova.addOrder(new Order(4)).addOrder(new Order(5));

		List<Customer> customers = Arrays.asList(sheridan, ivanova, garibaldi);

		List orders1 = customers.stream().map(Customer::getOrders).collect(Collectors.toList());

		System.out.println(orders1);

		Map<Integer, Order> orders2 = customers.stream().flatMap(customer -> customer.getOrders().stream()).collect(Collectors.toMap(Order::getId,Function.identity()));
	

		//List orders2 = customers.stream().flatMap(customer -> customer.getOrders().stream()).collect(Collectors.toMap(Order::getId,Function.identity())));

		System.out.println(orders2);
	}

}
