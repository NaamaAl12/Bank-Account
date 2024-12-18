// Naama Al-Musawi, CS& 141
// Final Assignment: Classes and Objects

import java.util.*;

public class BankAccountClient {
    private static BankAccount[] accounts = new BankAccount[3];
    private static Scanner console = new Scanner(System.in);
    private static Random rand = new Random();

    // The main method of the program
    public static void main(String[] args) {
        createBankAccounts();

        int choice = 0;
        while (choice != 8) {
            displayMenu(); // Displays the menu optins
            choice = getUserChoice(); // Gets the user's choice
            performAction(choice); // Performs the chosen action
        }
    }
    
    // Creates bank accounts by prompting the user for necessary details
    public static void createBankAccounts() {
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Creating Bank Account " + (i + 1));
            int accountNumber = generateAccountNumber();
            while (isAccountNumberUsed(accountNumber)) {
                accountNumber = generateAccountNumber();
            }
           
            String accountHolderName = getValidString("Enter the account holder name (First MiddleInitial. Last): ");
            double balance = getValidDoubleInput("Enter the account balance: ");
            double interestRate = getValidDoubleInput("Enter the interest rate (%): ");

            accounts[i] = new BankAccount(accountNumber, accountHolderName, balance, interestRate);
            System.out.println("Bank Account " + (i + 1) + " created successfully!");
            
        }
    }
    
    // Generates a random account number
    public static int generateAccountNumber() {
        return rand.nextInt(900000) + 100000;
    }
    
    // Checks if an account number is already used by any existing accounts
    public static boolean isAccountNumberUsed(int accountNumber) {
        for (int i = 0; i < accounts.length; i++) {
            BankAccount account = accounts[i];
            if (account != null && account.getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false;
    }
    
    // Displays the menu options
    public static void displayMenu() {
        System.out.println("Bank Account Menu:");
        System.out.println("1. Display information of an account");
        System.out.println("2. Deposit to an account");
        System.out.println("3. Withdraw from an account");
        System.out.println("4. Transfer between two accounts");
        System.out.println("5. Calculate Interest");
        System.out.println("6. Get the balance of an account");
        System.out.println("7. Change Account Details (Name)");
        System.out.println("8. Exit");
    }
    
    // Prompts the user for their choice and returns the user's choice
    public static int getUserChoice() {
        return getValidIntInput("Enter your choice: ");
    }
    
    // Performs the action based on the user's choice
    public static void performAction(int choice) {
        if (choice == 1) {
            displayAccountInfo();
        } 
        else if (choice == 2) {
            depositToAccount();
        } 
        else if (choice == 3) {
            withdrawFromAccount();
        } 
        else if (choice == 4) {
            transferBetweenAccounts();
        } 
        else if (choice == 5) {
            calculateInterest();
        } 
        else if (choice == 6) {
            getAccountBalance();
        } 
        else if (choice == 7) {
            changeAccountDetails();
        } 
        else if (choice == 8) {
            System.out.println("Exiting the program");
        } 
        else {
            System.out.println("Invalid choice. Please try again.");
        }
    }
    
    // Displays the information of a specific bank account
    public static void displayAccountInfo() {
        int accountIndex = getValidAccountIndex("Enter the account index: ");
        System.out.println(accounts[accountIndex]);
    }
    
    // Deposits an amount to a specific bank account
    public static void depositToAccount() {
        int accountIndex = getValidAccountIndex("Enter the account index: ");
        double amount = getValidDoubleInput("Enter the amount to deposit: ");
        accounts[accountIndex].changeBalance(amount);
        System.out.println("Deposit successful!");
    }
    
    // Withdraws an amount from a specific bank account
    public static void withdrawFromAccount() {
        int accountIndex = getValidAccountIndex("Enter the account index: ");
        double amount = getValidDoubleInput("Enter the amount to withdraw: ");
        if (accounts[accountIndex].getBalance() >= amount) {
            accounts[accountIndex].changeBalance(amount * -1);
            System.out.println("Withdrawal successful!");
        } 
        else {
            System.out.println("Insufficient funds. Withdrawal failed!");
        }
    }
    
    // Transfers an amount between two bank accounts
    public static void transferBetweenAccounts() {
        int fromAccountIndex = getValidAccountIndex("Enter the account index to transfer from: ");
        int toAccountIndex = getValidAccountIndex("Enter the account index to transfer to: ");
        double amount = getValidDoubleInput("Enter the amount to transfer: ");

        if (accounts[fromAccountIndex].getBalance() >= amount) {
            accounts[fromAccountIndex].changeBalance(amount * -1);
            accounts[toAccountIndex].changeBalance(amount);
            System.out.println("Transfer successful!");
        } 
        else {
            System.out.println("Insufficient funds. Transfer failed!");
        }
    }
    
    // Calculates interest for a specific bank account
    public static void calculateInterest() {
        int accountIndex = getValidAccountIndex("Enter the account index (0-2): ");
        int years = getValidIntInput("Enter the number of years: ");
        accounts[accountIndex].calculateInterest(years);
        System.out.println("Interest calculated and added to the account balance!");
    }
    
    // Gets the balance of a specific bank account
    public static void getAccountBalance() {
        int accountIndex = getValidAccountIndex("Enter the account index: ");
        System.out.println("Account Balance: $" + accounts[accountIndex].getBalance());
    }
    
    // Changes the account holder name for a specific bank account
    public static void changeAccountDetails() {
        int accountIndex = getValidAccountIndex("Enter the account index (0-2): ");
        String newName = getValidString("Enter the new account holder name: ");
        accounts[accountIndex].setName(newName);
        System.out.println("Account holder name updated successfully!");
    }
    
    // Prompts the user for a valid account index within the valid range
    public static int getValidAccountIndex(String message) {
        return getValidIntInput(message, accounts.length);
    }
    
    // Prompts the user for a valid integer input
    public static int getValidIntInput(String message) {
        System.out.print(message);
        while (!console.hasNextInt()) {
            System.out.print("Invalid input. Enter a valid number: ");
            console.nextLine();
        }
        int input = console.nextInt();
        console.nextLine();
        return input;
    }
    
    // Prompts the user for a valid double input
    public static double getValidDoubleInput(String message) {
        System.out.print(message);
        while (!console.hasNextDouble()) {
            System.out.print("Invalid input. Enter a valid number: ");
            console.nextLine();
        }
        double input = console.nextDouble();
        console.nextLine();
        return input;
    }
    
    // Prompts the user for a valid integer input within the specified range
    public static int getValidIntInput(String message, int max) {
        int input = getValidIntInput(message);
        while (input < 0 || input >= max) {
            System.out.print("Invalid input. Enter an index (0-" + (max-1) + "): ");
            input = getValidIntInput(message);
        }
        return input;
    }
    
    // Checks if the input name is valid, allowing letters, spaces, hyphens, and dots
    public static boolean getValidName(String input) {
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!(Character.isLetter(c) || c == ' ' || c == '-' || c == '.')) {
                return false;
            }
        }
        return true;
    }
    
    // Prompts the user for a valid string input for the account holder name
    public static String getValidString(String message) {
        System.out.print(message);
        String input = console.nextLine();
        while (input == "" || !getValidName(input)) {
            System.out.print("Invalid input. Enter a valid account holder name: ");
            input = console.nextLine();
        }
        return input;
    }
    
}