package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String account) {
		accountNo = account;
		System.out.println(accountNo + " 계좌가 개설되었습니다.");
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void save(int s_money) {
		balance += s_money;
		System.out.println(accountNo + " 계좌에 " + s_money + "만원이 입금되었습니다.");
		
	}

	public void deposit(int d_money) {
		balance -= d_money;
		System.out.println(accountNo + " 계좌에 " + d_money + "만원이 출금되었습니다.");
		
	}
	
	
	
}
