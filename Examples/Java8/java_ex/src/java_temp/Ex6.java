package java_temp;

import java.util.function.Function;

public class Ex6 {
	
	public static void main(String[] args) {
		
		Function<Integer,Integer> x = (a)->a*2;
		
		System.out.println(x.apply(10));
		
		
	}

}
