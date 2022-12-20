package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		int[] intArray = {1,2,3,4,5,6,7,8,9,10};
		
		for(int i=1; i<10; i++) {			
			for(int j=0; j<intArray.length; j++) {
				System.out.print(intArray[j]++ + " ");
			}						
			System.out.println();
		}
	}
}
