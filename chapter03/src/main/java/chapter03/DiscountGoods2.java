package chapter03;

import mypakage.Goods2;

public class DiscountGoods2 extends Goods2 {
	
	private long i = 1123445213545L;
	private float discountrate = 0.5f;
	
	public float getDiscountPrice() {
		// protected는 자식에서 접근 가능
		return discountrate*price;
	}

}
