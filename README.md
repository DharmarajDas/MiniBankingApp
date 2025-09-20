# MiniBankingApp

## 🏦 Project Overview
**MiniBankingApp** is a console-based Java banking application designed to simulate basic banking operations. Users can create accounts, deposit and withdraw money, transfer funds between accounts, and view their account details. The application emphasizes **simplicity, uniqueness of account IDs**, and **transaction transparency** with ATM-style receipts and transaction slips.

This project demonstrates **Object-Oriented Programming (OOP)** concepts, **file handling** for data persistence, and **user-friendly console interaction**.

---

## 💡 Features

- ✅ Create a new bank account with **auto-generated unique ID** (BANK1001, BANK1002, …)  
- ✅ Login using existing **Customer ID**  
- ✅ Check account **balance**  
- ✅ Deposit money with **transaction slip**  
- ✅ Withdraw money with **transaction slip**  
- ✅ Transfer money to other accounts with **transaction slip**  
- ✅ View **previous transaction history**  
- ✅ Show account details  
- ✅ Data stored in a **text file (`users.txt`)** for persistence between sessions  
- ✅ Console-based **ATM-style receipts** for account creation and transactions  

---

## ⚙️ Technologies Used

- Java SE (Java 8 or higher)  
- Object-Oriented Programming (OOP)  
- File Handling (Reading and Writing text files)  
- Scanner and Console Input/Output  

---

## 🏗️ Project Structure

MiniBankingApp/
│
├── BankApplication.java       # Main entry point
├── BankSystem.java            # Handles all accounts & transactions
├── BankAccount.java           # BankAccount class with transactions
├── users.txt                  # Stores all user accounts and balances
└── README.md                  # Project documentation

---

##🚀 How to Run

1. Clone the repository:
   git clone https://github.com/yourusername/MiniBankingApp.git

2. Open the project in your favorite IDE (Eclipse, IntelliJ IDEA, VS Code with Java extension)

3. Compile the Java files:
   javac BankApplication.java BankSystem.java BankAccount.java

4. Run the application:
   java BankApplication

5. Follow the on-screen instructions:

   Enter your Customer ID to login

   Or type "new" to create a new account (system generates a unique Bank ID)

   Use the menu to deposit, withdraw, transfer, check balance, or view account details

---

##🔮 Future Improvements

Add password-based authentication for security

Integrate a graphical user interface (GUI)

Connect to a real database (MySQL or SQLite) instead of text files

Implement multiple currencies and conversion rates

Add interest calculation for savings accounts

Generate transaction reports/export receipts as PDF

Add admin features to view all accounts and transactions

---

##💬 Usage Example

New Account Creation:
===================================
          🏦 MINI BANK ATM         
===================================
🎉 Account Created Successfully!
-----------------------------------
👤 Account Holder : John Doe
🆔 Customer ID    : BANK1001
💰 Starting Balance : 0.0
-----------------------------------
✨ Please remember your Customer ID.
===================================

Deposit Transaction Slip:
===================================
          🏦 TRANSACTION SLIP       
===================================
👤 Account Holder : John Doe
🆔 Customer ID    : BANK1001
📄 Transaction    : Deposit
💰 Amount         : 500
💵 Current Balance: 500
===================================

---

##📂 License
This project is open source and free to use for educational purposes.




  
