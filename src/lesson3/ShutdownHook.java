package lesson3;

import java.io.IOException;

public class ShutdownHook {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Thread t = new Thread(()->processExit());
		
		Runtime.getRuntime().addShutdownHook(t);
		System.err.println("Before exit");
		Runtime.getRuntime().halt(0);
	}

	public static void processExit() {
		System.err.println("Exit processed!");
	}
}
