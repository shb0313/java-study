package chapter04;

public class WrpperClassTest01 {

	public static void main(String[] args) {
		//직접 생성하면 힙상에 객체가 존재
		//리터럴을 사용하게 되면 JVM안의 Constant Pool이 관리
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		//Auto Boxing
		Integer j1 = 10;
		Integer j2 = 10;
		
		System.out.println(j1 == j2);
		System.out.println(j1.equals(j2));
		
		//Auto Unboxing
		//int m = j1.intValue() + 10;
		int m = j1 + 10;
		
	}

}
