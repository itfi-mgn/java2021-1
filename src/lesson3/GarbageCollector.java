package lesson3;

public class GarbageCollector {

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.err.println("Finalize");
		super.finalize();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GarbageCollector	gc = new GarbageCollector();
		gc = null;
		System.gc();
		Runtime.getRuntime().runFinalization();
		System.runFinalization();
	}

}
