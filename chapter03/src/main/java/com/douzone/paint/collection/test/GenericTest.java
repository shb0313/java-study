package com.douzone.paint.collection.test;

import java.util.ArrayList;
import java.util.List;
import com.douzone.paint.collection.MyStack;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.i.Drawable;

public class GenericTest {

	public static void main(String[] args) {
		drawShape(new Rect());
		//drawShape(new Point());
		
		MyStack <? extends Shape> s1 = null;
		MyStack <? super Shape> s2 = null;
		
		List<Rect> list1 = new ArrayList<>();
		List<Rect> list2 = new ArrayList<>();
		
		MyStack<Drawable> s = new MyStack<>(20);
		drawShapeLayer(list1, null);
		drawShapeLayer(list2, s);
		
	}
	
	/**
	 * Generic Parameter 제한01 : extends
	 * 1) hierachy max
	 * 2) 자신포함 자식들만
	 */
	
	public static <T extends Shape> void drawShape(T t) {
		t.draw();
	}
		
	/**
	 * Generic Parameter 제한02 : super
	 * 1) hierachy min
	 * 2) 자신포함 부모들만
	 * 3) <T super Type> 오류!!
	 *    - 함수 구현 블록(클래스 구현 블록) 안에서 T 타입이 모호하기 떄문에 구현이 불가능
	 *    - Type Erasing의 결과 <T super Type>은 Object이기 때문에 문법적 의미가 없음
	 *    - 결론은 존재하지 않음
	 */
	
//	public static <T super Shape> void drawShape(T t) {
//		t.draw();
//	}
	
	/**
	 * Generic Parameter wildcard : ?
	 * 1) 제네릭 타입의 클래스를 사용할 때(메소드에 사용 불가), 
	 *    제한(extends, super와 함께)적으로 제네릭 타입을 결정해야할 때 사용 
	 * 2) 사용할 수 없는 예
	 *    - 클래스를 제네릭 타입으로 정의할 때              
	 *        MyStack<?> x
	 *    - 클래스를 Shape 자식의 제네릭 타입으로 정의할 때   
	 *        MyStack<? extends Shape> x
	 *    - 메소드의 첫 번째 파라미터를 제네릭 타읍으로 할 때  
	 *        <?> void m(> t) x
	 *    - 메소드의 첫 번째 파라미터를 Shape 자식의 제네릭 타입으로 할 때
	 *        <? extends Shape m(? t) x 
	 * 3) 사용할 수 있는 예 
	 *    - 제네릭 클래스 MyStack의 제네릭 파라미터를 Shape의 자식으로만 할 때
	 *        MyStack <? extends Shape> 
	 *    - 제네릭클래스 MyStack의 제네릭 파라미터를 Shape의 부모로만 할 때
	 *        MyStack <? super Shape>
	 * @param <Drawable>
	 */
	
	public static <Drawable> void drawShapeLayer(
			List<?extends Shape> in,           /* Producer, Lower Bounded */
			MyStack<? super Drawable> out /* Consumer, Upper Bounded */) {   
		//잘못된 사용
		//MyStack <? extends Shape> s1 = new MyStack<>(10);
		//s1.push(new Rect());
		
		for(Shape s : in) {
			out.push(s);
		}
		
	}
}
