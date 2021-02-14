package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;

abstract class AbstractBankAccount implements BankAccount{
	
	public static final double ATM_TRANSACTION_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;

    private double balance;
    private int nTransactions;
    private final int usrID;
    
    protected AbstractBankAccount(final int usrID, int nTransaction, double balance) {
    	this.usrID = usrID;
    	this.balance = balance;
    	this.nTransactions = 0;
    }

    protected boolean checkUser(final int id) {
        return this.usrID == id;
    }
    
    protected abstract boolean isWithdrawAllowed(double amount);
    
    protected abstract double computeFee();
    
    protected final void resetTransactions() {
        this.nTransactions = 0;
    }
    
    public void computeManagementFees(int usrID) {
    	final double feeAmount = computeFee();
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
            balance -= feeAmount;
            resetTransactions();
        }
    }
    
    private void transactionOp(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.incTransactions();
        }
    }
    
    protected final void incTransactions() {
        this.nTransactions++;
    }

    public void deposit(int usrID, double amount) {
    	this.transactionOp(usrID, amount);
    }

    public void depositFromATM(int usrID, double amount) {
    	this.deposit(usrID, amount - ATM_TRANSACTION_FEE);
    }

    public double getBalance() {
    	return this.balance;
    }

    public int getNTransactions() {
    	return this.nTransactions;
    }

    public void withdraw(int usrID, double amount) {
    	if (isWithdrawAllowed(amount)) {
    		this.transactionOp(usrID, -amount);
    	}
    }

    public void withdrawFromATM(int usrID, double amount) {
    	this.withdraw(usrID, amount + ATM_TRANSACTION_FEE);
    }
	
}
