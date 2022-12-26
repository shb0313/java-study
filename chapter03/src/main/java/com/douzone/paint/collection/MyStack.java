package com.douzone.paint.collection;

public class MyStack<T> {
	private T[] buffer;
	private int top;
	
	@SuppressWarnings("unchecked")
	public MyStack(int i) {
		buffer = (T[])new Object[i];
		top = -1;
	}

	public void push(T t) {
		if(top == buffer.length - 1) {
			resize();
		}
		
		buffer[++top] = t;
	}

	public T pop() throws MyStackException{
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}

		T result = buffer[top];		
		buffer[top--] = null;

		return result;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	@SuppressWarnings("unchecked")
	public void resize() {
		T[] temp = (T[])new Object[buffer.length * 2];
		for (int i = 0; i <= top; i++) {
			temp[i] = buffer[i];
		}

		buffer = temp;
	}
}