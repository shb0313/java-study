package prob3;

public class Sparrow extends Bird {
	@Override
	public void fly() {
		System.out.println("오리(" + getName() + ")는 날지 않습니다.");
	}
	@Override
	public void sing() {
		System.out.println("오리(" + getName() + ")가 소리내어 웁니다.");
	}
	public String toString() {
		return "참새의 이름은 짹쨱 입니다";
	}
}
