package java_temp;

import java.util.function.BiFunction;

public class Ex7 {

	public static Integer add(Integer i, Integer j) {
		return i + j;
	}

	public static Integer substract(Integer i, Integer j) {
		return i - j;
	}

	public static Integer f1(BiFunction<Integer, Integer, Integer> combine, Integer t, Integer u) {
		return combine.apply(t, u);
	}

	public static void main(String[] args) {
		System.out.println(f1(Ex7::add,10,20));
		System.out.println(f1(Ex7::substract,10,20));
		System.out.println(f1((a,b)->{return a+b;},10,20));
	}

}
