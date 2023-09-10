package java_temp;

import java.io.File;
import java.util.stream.Stream;

public class Ex2 {

	public static void main(String[] args) {
		String dir1 = System.getProperty("user.dir");
		System.out.println(dir1);

		File directory = new File(dir1 + "./src/java_temp");
		String[] names = directory.list((File dir, String name) -> name.endsWith(".java"));
		System.out.println(names.length);

		Stream.of("this", "is", "a", "stream", "of", "strings").map(String::length).forEach(System.out::println);
	}

}
