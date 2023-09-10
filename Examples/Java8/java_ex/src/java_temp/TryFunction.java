package java_temp;

@FunctionalInterface
public interface TryFunction<T, U, V, R> {

	public R apply(T t, U u, V v);

}