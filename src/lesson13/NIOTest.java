package lesson13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class NIOTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final File	f = new File(System.getProperty("java.io.tmpdir"),"x.txt");

//		try(final FileOutputStream	fos = new FileOutputStream(f)) {
		f.delete();
		try(final FileChannel		fc = /*fos.getChannel();*/
							(FileChannel) Files.newByteChannel(f.toPath(), 
				StandardOpenOption.CREATE_NEW,
				StandardOpenOption.TRUNCATE_EXISTING,
				StandardOpenOption.WRITE)){
			
			final ByteBuffer		b = ByteBuffer.allocate(1024);
			
			b.put("test string 1".getBytes());
			b.flip();
			fc.write(b);
			b.clear();
			b.put("another test string".getBytes());
			b.flip();
			fc.write(b);
			fc.force(true);
		}
		
		try(final InputStream	is = new FileInputStream(f);
			final Reader		rdr = new InputStreamReader(is);
			final BufferedReader	brdr = new BufferedReader(rdr)) {
		
			String	line;
			
			while ((line = brdr.readLine()) != null) {
				System.err.println("Line: "+line);
			}
		}
	}

}
