package exception;

import java.io.IOException;

public class MyClass {
	
	
	public void danger() throws IOException {
		System.out.println("Some code1...");
		System.out.println("Some code2...");
		
		if( 3 - 3 == 0) {
			throw new MyException();
		}
		
		
		if(5-5==0) {
			throw new IOException();
		}
				
		System.out.println("Some code3...");
		System.out.println("Some code4...");
	}
}