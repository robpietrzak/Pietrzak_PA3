public class SavingsAccountTest{

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount();
		SavingsAccount saver2 = new SavingsAccount();
		
		saver1.setSavingsBalance(2000);
		saver2.setSavingsBalance(3000);
		
		saver1.modifyInterestRate(0.04);
		saver2.modifyInterestRate(0.04);
		
		System.out.println("Saver 1 after 12 months: " + saver1.calculateMonthlyInterest() * 12);
		System.out.println("Saver 2 after 12 months: " + saver2.calculateMonthlyInterest() * 12);
		
		saver1.setSavingsBalance(saver1.calculateMonthlyInterest() * 12);
		saver2.setSavingsBalance(saver2.calculateMonthlyInterest() * 12);
		
		System.out.println("");
		
		saver1.modifyInterestRate(0.05);
		saver2.modifyInterestRate(0.05);
		
		System.out.println("Saver 1 after 1 month: " + saver1.calculateMonthlyInterest());
		System.out.println("Saver 2 after 1 month: " + saver2.calculateMonthlyInterest());
	}
}
