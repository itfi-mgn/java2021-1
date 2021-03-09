package lesson2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ProcessTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Process	p = Runtime.getRuntime().exec("cmd /c \"dir\"");

		Thread	t = new Thread(()->{
			try(final Reader	rdr = new InputStreamReader(p.getInputStream(),"cp866");
				final BufferedReader	brdr = new BufferedReader(rdr)) {
			
				String	line;
				while ((line = brdr.readLine()) != null) {
					System.err.println("line="+line);
				}
			} catch (Exception exc) {
			}
		}
		);
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

		// to write to p.getOutputStream()
		p.waitFor();
		System.err.println("ExitValue="+p.exitValue());
		
//		Process		pp = new ProcessBuilder().command("cmd /c \"dir\"")
//								.directory(new File("d:/chav1961"))
//								.start();
		
	}
}
