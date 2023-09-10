package java_temp;

public class Ex8 {

	public static void main(String[] args) {

		TryFunction<Integer, Integer, Integer, Integer> t1 = (a, b, c) -> a + b + c;

		System.out.println(t1.apply(10, 20, 30));

	}

}
