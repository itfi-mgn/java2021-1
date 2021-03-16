package lesson2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CallUpperCase {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		final Process	p = new ProcessBuilder()
							.command("c:/program files/java/jdk-13.0.1/bin/java.exe","-Dkey=value","lesson2/Calculator","abcde")
//							.command("c:/program files/java/jdk-13.0.1/bin/java.exe","-Dkey=value","lesson2/UpperCase","abcde")
							.directory(new File("D:/eclipse-ws/java2021-1/bin"))
							.start();
		Thread	t = new Thread(()->{
			try(final Reader	rdr = new InputStreamReader(p.getInputStream(),"cp866");
				final BufferedReader	brdr = new BufferedReader(rdr)) {
			
				String	line;
				while ((line = brdr.readLine()) != null) {
					System.out.println("line="+line);
				}
			} catch (Exception exc) {
			}
		});
		t.start();

		Thread	t1 = new Thread(()->{
			try(final Reader	rdr = new InputStreamReader(p.getErrorStream(),"cp866");
				final BufferedReader	brdr = new BufferedReader(rdr)) {
			
				String	line;
				while ((line = brdr.readLine()) != null) {
					System.err.println("error="+line);
				}
			} catch (Exception exc) {
			}
		}
		);
		t1.start();
		
		
		try(final Writer	wr = new OutputStreamWriter(p.getOutputStream())) {
//			wr.write("test\n");
//			wr.write("new test\n");
//			wr.write("last test\n");
			wr.write("15+3+10+22\n");
			wr.flush();
		}
		p.waitFor();
		System.err.println("EXit code: "+p.exitValue());
	}
}
