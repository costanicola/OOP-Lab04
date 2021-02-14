package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount {

	protected ClassicBankAccount(int usrID, int nTransaction, double balance) {
		super(usrID, nTransaction, balance);
	}

	@Override
	protected boolean isWithdrawAllowed(double amount) {
		return true;
	}

	@Override
	protected double computeFee() {
		return MANAGEMENT_FEE;
	}

}
