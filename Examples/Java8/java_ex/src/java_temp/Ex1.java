package java_temp;

public class Ex1 {

	public static void main(String[] args) {
		Runnable r = () -> System.out.println("hello");
		new Thread(r).start();
	}

}
