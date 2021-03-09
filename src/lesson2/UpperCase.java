package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class UpperCase {
	public static void main(String[] args) throws IOException {
		System.err.println("Args: "+Arrays.toString(args));
		System.err.println("-D: "+System.getProperty("key"));
		try(final Reader	rdr = new InputStreamReader(System.in);
			final BufferedReader	brdr = new BufferedReader(rdr)) {
		
			String	line;
			while ((line = brdr.readLine()) != null) {
				System.out.println(line.toUpperCase());
			}
		}
		System.exit(100);
	}
}
