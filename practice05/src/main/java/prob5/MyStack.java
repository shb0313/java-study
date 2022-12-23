package prob5;



public class MyStack {
	private String[] buffer;
	private String[] newBuffer;
	private int index;
	
	public MyStack(int i) {
		buffer = new String[i];
		newBuffer = new String[i];
		index = 0;
	}

	public void push(String string) {
		index++;
		
		if(index > buffer.length) {
			buffer = new String[index];
			for(int i = 0; i < newBuffer.length; i++) {
				buffer[i] = newBuffer[i];
			}
			buffer[index-1] = string; 
			
			newBuffer = new String[index];
			for(int i = 0; i < index; i++) {
				newBuffer[i] = buffer[i];
			}
		}else {
			buffer[index-1] = string;
			newBuffer[index-1] = string;
		}
	}

	public boolean isEmpty() {
		if(index-1 < 0) {
			index = 0;
			return true; 
		}
		
		return false;
	}

	public String pop() throws MyStackException {
		index--;
		if(index < 0) {
			throw new MyStackException();
		}
		return buffer[index];
	}
}