package lesson3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		ClassLoader	cl = new ClassLoader(ClassLoaderTest.class.getClassLoader()) {
								@Override
								public Class<?> loadClass(String name) throws ClassNotFoundException {
									if (name.equals("lesson3.Security")) {
										final byte[]	buffer = new byte[10000];
										int				length;
										
										try(final InputStream	is = new FileInputStream("D:/eclipse-ws/java2021-1/bin/lesson3/Security.class")) {
											
											length = is.read(buffer);
											return defineClass("lesson3.Security",buffer,0,length);
										} catch (IOException e) {
											throw new ClassNotFoundException("lesson3.Security");
										}
									}
									else {
										
									}
									return super.loadClass(name);
								}
						};
	ClassLoader	cl1 = new ClassLoader(ClassLoaderTest.class.getClassLoader()) {
							@Override
							public Class<?> loadClass(String name) throws ClassNotFoundException {
								if (name.equals("lesson3.Security")) {
									final byte[]	buffer = new byte[10000];
									int				length;
									
									try(final InputStream	is = new FileInputStream("D:/eclipse-ws/java2021-1/bin/lesson3/Security.class")) {
										
										length = is.read(buffer);
										return defineClass("lesson3.Security",buffer,0,length);
									} catch (IOException e) {
										throw new ClassNotFoundException("lesson3.Security");
									}
								}
								else {
									
								}
								return super.loadClass(name);
							}
					};
						
		Class<Security>	sec = (Class<Security>) cl.loadClass("lesson3.Security");
		Class<Security>	sec1 = (Class<Security>) cl1.loadClass("lesson3.Security");
		
		Security		secInst = sec1.newInstance();
	}
}
