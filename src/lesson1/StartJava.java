package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class StartJava {

	public static void main(String[] args) throws IOException {	// -Dmykey=myvalue {"abcde", "123", "-t"}
		// TODO Auto-generated method stub
		System.err.println("Hello world: "+Arrays.toString(args));
		System.err.println("-D keys: "+System.getProperties());
		System.err.println("tmpdir: "+System.getProperty("java.io.tmpdir"));
		System.err.println("MyKey: "+System.getProperty("mykey"));
		System.err.println("Err stream");
		System.out.println("Out stream");
		
		try(final Reader	rdr = new InputStreamReader(System.in);
			final BufferedReader	brdr = new BufferedReader(rdr)){
		
			String	s;
			
			while ((s = brdr.readLine()) != null) {
				System.out.println(s.toUpperCase());
			}
		}
	}
}
