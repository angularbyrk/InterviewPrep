package com.cenit.corejava.java8.functional.consumers;

import java.util.stream.Stream;

public class Ex1 {

	public static void main(String[] args) {
		Consumer c = new Consumer();
		Stream.of("h1", "how").forEach(c::accept);

	}

}

class Consumer<String> {
	public void accept(String data) {
		System.out.println(data);
	}
}
