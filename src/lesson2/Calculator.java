package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Calculator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 1. get string  15+3+10+22
		// 2. calculate result and return it
		try(final Reader	rdr = new InputStreamReader(System.in);
			final BufferedReader	brdr = new BufferedReader(rdr)) {
		
			String	line;
			while ((line = brdr.readLine()) != null) {
				int	sum = 0;
				
				for (String item : line.split("\\+")) {
					sum += Integer.valueOf(item);
				}
				System.out.println(sum);
			}
		}
	}
}
