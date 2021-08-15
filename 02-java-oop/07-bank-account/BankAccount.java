public class BankAccount{

    public static int numAccounts = 0;
	public static double totalBalances = 0;
    private double checkingBalance;
    private double savingsBalance;

    public BankAccount(double checkingBalance, double savingsBalance){
        BankAccount.numAccounts += 1;
		this.checkingBalance = 0;
		this.savingsBalance = 0;
    }


//Getters
    public double getCheckingBalance() {
		return this.checkingBalance;
	}

	public double getSavingsBalance() {
		return this.savingsBalance;
	}

    public void depositMoney(double amount, String account) {
		if(account.equals("Savings"))
			this.savingsBalance += amount;
		else if(account.equals("Checking"))
			this.checkingBalance += amount;
		BankAccount.totalBalances += amount;
	}

	public void withdrawMoney(double amount, String account) {
		boolean successful = false;
		if(account.equals("Savings")) {
			if(this.savingsBalance - amount >= 0) {
				successful = true;
				this.savingsBalance -= amount;
			}
		}
		else if(account.equals("Checking")) {
			if(this.checkingBalance - amount >= 0) {
				successful = true;
				this.checkingBalance -= amount;
			}
		}
		if(successful) {
			BankAccount.totalBalances -= amount;
		}
	}

    public void displayAccountBalance() {
		System.out.println(String.format("Savings: %.2f, Checking: %.2f", this.savingsBalance, this.checkingBalance));
	}

}