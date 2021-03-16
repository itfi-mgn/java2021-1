package lesson3;

public class Security {
	public static final int x = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecurityManager	sm = new SecurityManager() {
								@Override
								public void checkExit(int status) {
									System.err.println("Attempt to call exit!!!");
									super.checkExit(status);
									throw new SecurityException("JKkjgfkljdfklgjkldfjgkldfjg!!!!");
								}							
							};
		System.setSecurityManager(sm);
		System.exit(0);
	}
}
