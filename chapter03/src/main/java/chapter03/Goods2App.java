package chapter03;

import mypakage.Goods2;

public class Goods2App {

	public static void main(String[] args) {
		Goods2 g = new Goods2();
		
		//public 접근제한이 없음
		g.name = "camera";
		
		//protexted는 같은 패키지에서 접근 가능
		//더 중요한건 자식에서 접근 가능**
		//g.price = 10000;
		
		//디폴트는 가튼 패키지에서 접근 가능
		//g.countStoct = 10;
		
		//private는 같은 클래스에서만 접근 가능
		//g.countSold = 50;
		
	}

}
