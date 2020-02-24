
public class SavingsAccount {
	
	public static double annualInterestRate;
	private double savingsBalance;
	
	public double calculateMonthlyInterest()
	{
		savingsBalance = savingsBalance + ((annualInterestRate * getSavingsBalance()) / 12);
		return getSavingsBalance();
	}
	
	public static double modifyInterestRate(double rate)
	{
		annualInterestRate = rate;
		return rate;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
}
