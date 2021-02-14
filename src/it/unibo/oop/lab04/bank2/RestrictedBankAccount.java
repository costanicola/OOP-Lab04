package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount {

	public static final double TRANSACTION_FEE = 0.1;
	
	protected RestrictedBankAccount(int usrID, int nTransaction, double balance) {
		super(usrID, nTransaction, balance);
	}

	@Override
	protected boolean isWithdrawAllowed(double amount) {
		return getBalance() > amount;
	}

	@Override
	protected double computeFee() {
		return MANAGEMENT_FEE + (getNTransactions() * TRANSACTION_FEE);
	}

}
