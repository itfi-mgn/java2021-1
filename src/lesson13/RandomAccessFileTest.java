package lesson13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		final File	f = new File("c:/temp/zzz.txt");
		
		try(final RandomAccessFile	raf = new RandomAccessFile(f, "rw")) {
			
		}
	}

}
