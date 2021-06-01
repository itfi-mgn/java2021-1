package lesson12;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final File	f = new File("c:/temp");
		final Path	p = f.toPath();
		final Path	ppp = Paths.get("c:/temp");
		
		
//		final DirectoryStream<Path>	ps = Files.newDirectoryStream(p, "*.txt");
		for (Path pp : Files.newDirectoryStream(p, "*.txt")) {
			System.err.println("PP="+pp);
		}
		
		
		// Copy c:/temp to c:/temp1
	}

}
