package com.cenit.corejava.java8;

public class Ex1 {

	public static void main(String[] args) {
		MyFunction<String, String, String> abc = (a, b) -> a + b;

		String result = abc.apply("hi,", " how are yoou");
		
		System.out.println(result);
	}

}
