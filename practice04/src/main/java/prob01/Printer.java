package prob01;

public class Printer {
/*
	public void println(int num) {
		System.out.println(num);
	}
	
	public void println(boolean bool) {
		System.out.println(bool);
	}
	
	public void println(double num) {
		System.out.println(num);
	}
	
	public void println(String string) {
		System.out.println(string);
	}
*/	
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.println(t);
		}
	}
	
	public int sum(Integer... nums) {
		int s = 0;
		for(Integer n : nums) {
			s += n;
		}
		return s;
	}
}
