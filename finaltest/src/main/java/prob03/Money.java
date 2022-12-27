package prob03;

public class Money {
	private int amount;
	
	/* 코드 작성 */
	public Money(int amount) {
		this.amount = amount;
	}

	public Object add(Money money) {
		Money newMoney = new Money(this.amount + money.amount);
		return newMoney;
	}

	public Object minus(Money money) {
		Money newMoney = new Money(this.amount - money.amount);
		return newMoney;
	}

	public Object multiply(Money money) {
		Money newMoney = new Money(this.amount * money.amount);
		return newMoney;
		
	}

	public Object devide(Money money) {
		Money newMoney = new Money(this.amount / money.amount);
		return newMoney;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
			
		if (obj == null) {
			return false;
		}
			
		if (getClass() != obj.getClass()) {
			return false;
		}
					
		Money other = (Money) obj;
		if (amount == 0) {
			if (other.amount != 0)
				return false;
		} else if (!obj.equals(other)) {
			return false;
		}
		return true;
	}
}
