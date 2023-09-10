package java_temp;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ex11 {
	public static void main(String[] args) {
		TryFunction<Integer, Integer, Integer, Integer> add = (a, b, c) -> a + b + c;

		Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial = x -> (y, z) -> add.apply(x, y, z);

		Function<Integer, Function<Integer, Function<Integer, Integer>>> addCurry = x -> y -> z -> add.apply(x, y, z);

		Function<Integer, Function<Integer, Integer>> partial1 = addCurry.apply(1);
		Function<Integer, Integer> partial2 = partial1.apply(2);

		System.out.println(addCurry.apply(10).apply(20).apply(30));

	}

}
