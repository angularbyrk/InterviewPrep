package java_temp;

import java.util.ArrayList;

public class Ex3 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		list.stream().forEach((n) -> System.out.println(n));
		
		list.stream().map((v) -> v * 2).forEach((n) -> System.out.println(n));
		
	}
}
