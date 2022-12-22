package prob03;

public class CurrencyConverter {
	private static double rate;

	public static double getRate() {
		return rate;
	}

	public static void setRate(double r) {
		rate = r;
	}

	public static double toDollar(double won) {
		double dollar = won/rate;
		return (double)dollar;
	}

	public static double toKRW(double dollar) {
		double krw = dollar*rate;
		return krw;
	}
	
	
	
	
	
}
