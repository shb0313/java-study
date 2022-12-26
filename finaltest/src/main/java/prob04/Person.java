package prob04;

public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	
	/* 코드 작성 */
	public Person(String string) {
		this.name = string;
		this.age = 12;
		numberOfPerson++;
	}
	
	public Person(int i, String string) {
		this.name = string;
		this.age = i;
		numberOfPerson++;
	}

	public static String getPopulation() {
		String population = String.valueOf(numberOfPerson);
		return population;
	}

	public void selfIntroduce() {
		System.out.println("내 이름은" + name + "이며, 나이는 " + age + "살 입니다.");
		
	}
	
}
