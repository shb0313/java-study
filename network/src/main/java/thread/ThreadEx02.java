package thread;

public class ThreadEx02 {

	public static void main(String[] args) {
		Thread thread01 = new DigitThread();
		Thread thread02 = new AlpabetThread();
		
		thread01.start();
		thread02.start();
		
	}

}
