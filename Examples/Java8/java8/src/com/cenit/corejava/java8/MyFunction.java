package com.cenit.corejava.java8;

public interface MyFunction<U, V, T> {

	public T apply(U u, V v);

	default void hello1() {

	}

	default void hello2() {

	}

	static void sayHello1() {

	}

	static void sayHello2() {

	}

}
