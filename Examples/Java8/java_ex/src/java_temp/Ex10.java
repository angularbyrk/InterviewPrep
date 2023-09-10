package java_temp;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex10 {

	public static void main(String[] args) {

		Function<Integer, Integer> multiplyByTwo = x -> x * 2;
		Predicate<Integer> findEven = x -> x % 2 == 0;

		List<Double> values = Stream.of(1, 2, 3, 4).map(multiplyByTwo).map(x -> Double.valueOf(x.intValue()))
				.collect(Collectors.toList());

		List<Double> evenValues = Stream.of(1, 2, 3, 4).filter(findEven).map(x -> Double.valueOf(x.intValue()))
				.collect(Collectors.toList());

		System.out.println(evenValues);
	}

}
