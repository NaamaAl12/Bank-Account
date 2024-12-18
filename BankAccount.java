// Naama Al-Musawi, CS& 141
// Final Assignment: Classes and Objects


/**
 * Represents a bank account with account number, account holder name, balance, and interest rate.
 */

public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private double interestRate;

    /**
     * Default constructor for BankAccount class.
     * Initializes accountNumber, accountHolderName, balance, and interestRate to default values.
     */
    
    public BankAccount() {
        int accountNumber = 0;
        double balance = 0.0;
        String accountHolderName = "";
        double interestRate = 0.0;
    }
    
    /**
     * Full constructor for BankAccount class.
     * Initializes accountNumber, accountHolderName, balance, and interestRate with provided values.
     * @param accountNumber, the account number of the bank account
     * @param accountHolderName, the account holder name of the bank account
     * @param balance, the balance of the bank account
     * @param interestRate, the interest rate of the bank account
     */
    
    public BankAccount(int accountNumber, String accountHolderName, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.interestRate = interestRate;
    }
    
    /**
     * Returns a string representation of the BankAccount object.
     * @return the account holder's name and account details.
     
     */

    public String toString() {
        return accountHolderName + " [" + accountNumber + "] :: Balance: $" + String.format("%.1f", balance);
    }
    
    /**
     * Returns the account holder name of the bank account.
     * @return the account holder name
     */

    public String getName() {
        return accountHolderName;
    }
    
    /**
     * Returns the balance of the bank account.
     * @return the balance
     */

    public double getBalance() {
        return balance;
    }
    
    /**
     * Returns the account number of the bank account.
     * @return the account number
     */

    public int getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Sets the account holder name of the bank account.
     * @param newName, the new account holder name
     */

    public void setName(String newName) {
        accountHolderName = newName;
    }
    
    /**
     * Changes the balance of the bank account by the given amount.
     * @param amount, the amount to change the balance by
     */

    public void changeBalance(double x) {
        balance += x;
    }
    
    /**
     * Sets the interest rate of the bank account.
     * @param rate, the interest rate to set
     */

    public void setInterestRate(double rate) {
        interestRate = rate;
    }
    
    /**
     * Calculates and adds the interest amount to the balance of the bank account.
     * @param years, number of years user inputs to calculate the interest
     */

    public void calculateInterest(int years) {
        double interestAmount = (years * balance * interestRate / 100);
        balance += interestAmount;
    }
}