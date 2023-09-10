package java_temp;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ex9 {

	public static void main(String[] args) {

		BiFunction<Float, Float, Float> divide = (i, j) -> {
			return i / j;
		};

		Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> argCheck = (func) -> {
			return (i, j) -> {
				if (i == 0f) {
					System.out.println("Error: second argument is zero.");
					return 0f;
				}
				return func.apply(i, j);
			};
		};

	}

}
