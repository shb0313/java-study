package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) throws MyException {
		
		try {
			MyClass myClass = new MyClass();
			myClass.danger();
			
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("eror : " + e);
		}
	}

}
