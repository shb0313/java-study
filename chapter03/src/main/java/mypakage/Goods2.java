package mypakage;

public class Goods2 {
	public String name;       //모든 접근이 가능(접근제한 없음)
	protected int price;      //같은 패키지 + *자식 클래스에서 접근 가능*
	int countStoct;           //같은 패키지, 디퐇트
	private int countSold;    //클래스 내부에서만 접근 가능
	
	public void m() {
		countSold = 50;
	}
	
	
}
