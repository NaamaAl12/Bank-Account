# 🏦 Bank Account Management System

This project is a **Java-based console application** for managing bank accounts. It simulates basic banking operations such as deposits, withdrawals, account creation, and interest calculation, while demonstrating key object-oriented programming principles.

---

## **Features**

1. **Account Management**:
   - Create up to three bank accounts with unique account numbers.
   - Update account holder names and view account details.

2. **Transactions**:
   - Deposit or withdraw funds.
   - Transfer money between accounts.

3. **Interest Calculation**:
   - Calculate and apply interest to an account balance for a specified number of years.

4. **Error Handling**:
   - Input validation for account details and transaction amounts.
   - Prevents invalid operations like overdrafts or duplicate account numbers.

---

## **How It Works**

1. **Menu-Driven Interface**:
   - The program uses a simple text-based menu to perform actions:
     ```
     Bank Account Menu:
     1. Display information of an account
     2. Deposit to an account
     3. Withdraw from an account
     4. Transfer between two accounts
     5. Calculate Interest
     6. Get the balance of an account
     7. Change Account Details (Name)
     8. Exit
     ```

2. **Core Classes**:
   - **`BankAccount`**:
     - Represents a bank account with fields for account number, account holder name, balance, and interest rate.
     - Includes methods for balance changes, interest calculation, and account information updates.
   - **`BankAccountClient`**:
     - Provides the user interface and handles user interactions such as account creation and transactions.

---

## **Getting Started**

### Prerequisites
- **Java Development Kit (JDK)** version 8 or higher.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/BankAccountManagement.git
   cd BankAccountManagement
