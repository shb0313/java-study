package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for (int i = 1; i < 1000; i++) {				
			String number = String.valueOf(i);
			String[] game = number.split("");
			
			if(number.contains("3") || number.contains("6") || number.contains("9")) {
				System.out.print(number + " ");
				
		
				for(int j = 0; j<game.length; j++) {
					if(game[j].equals("3") || game[j].equals("6") || game[j].equals("9")) {
						System.out.print("짝");
					}
				}
				System.out.println();
			}
		}
	}
}
d