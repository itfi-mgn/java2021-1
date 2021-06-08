package lesson13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class MappedTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final File	f = new File(System.getProperty("java.io.tmpdir"),"testFile.txt");
		
		f.delete();
		try(final FileChannel 	fileChannel = (FileChannel) Files.newByteChannel(f.toPath(), EnumSet.of(StandardOpenOption.READ, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE))) {
			
			final MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 4096);

			if (mappedByteBuffer != null) {
				mappedByteBuffer.put("test string".getBytes());
				mappedByteBuffer.force();
			}
		}
		
		try(final InputStream		is = new FileInputStream(f);
			final Reader			rdr = new InputStreamReader(is);
			final BufferedReader	brdr = new BufferedReader(rdr)) {
			String	line;
			
			while ((line = brdr.readLine()) != null) {
				System.err.println("line="+line);
			}
		}

	}

}
