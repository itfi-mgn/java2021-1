package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.Function;

public class Exercises {
		// java lesson1/Exercises {-U|-L} 
	public static void main(String[] args) throws IOException { 
		if (args.length > 0) {
			switch (args[0].toUpperCase()) {
				case "-U" : 
					process((s)->s.toUpperCase());
					break;
				case "-L" : 
					process((s)->s.toLowerCase());
					break;
				default :
					System.err.println("Unknown parameter ["+args[0]+"], use Exercises {-U|-L}!");
			}
		}
		else {
			System.err.println("No any parameters typed, use Exercises {-U|-L}!");
		}
	}

	private static void process(final Function<String, String> f) throws IOException {
		try(final Reader	rdr = new InputStreamReader(System.in);
			final BufferedReader	brdr = new BufferedReader(rdr)){
		
			String	s;
			
			while ((s = brdr.readLine()) != null) {
				System.out.println(f.apply(s));
			}
		}
	}
}
