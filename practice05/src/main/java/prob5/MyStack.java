package prob5;

import java.util.Stack;

public class MyStack {
	private String[] buffer;
	
	public MyStack(int i) {
		String[] buffer = new String[i];
		
	}

	public void push(String string) {
		int i = 0;
		buffer[i] = string;
		
		if(i > buffer.length) {
			buffer. = i;
		} else {
			i++;
		}
		
		
		
	}

	public boolean isEmpty() {
		
		return false;
	}

	public String pop() {
		
		return null;
	}
	
	
}