import java.util.Scanner;

public class BankAccount {
    double bal;
    double prevTrans;
    String customerName;
    String customerId;

    BankAccount(String customerName, String customerId, double balance) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.bal = balance;
    }

    // Transaction slip
    void printTransactionSlip(String type, double amount, String receiver) {
        System.out.println("\n===================================");
        System.out.println("          🏦 TRANSACTION SLIP       ");
        System.out.println("===================================");
        System.out.println("👤 Account Holder : " + customerName);
        System.out.println("🆔 Customer ID    : " + customerId);
        System.out.println("📄 Transaction    : " + type);
        System.out.println("💰 Amount         : " + amount);
        if (receiver != null)
            System.out.println("➡️ Receiver       : " + receiver);
        System.out.println("💵 Current Balance: " + bal);
        System.out.println("===================================\n");
    }

    void deposit(double amount) {
        if (amount > 0) {
            bal += amount;
            prevTrans = amount;
            printTransactionSlip("Deposit", amount, null);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    void withdraw(double amt) {
        if (amt > 0 && bal >= amt) {
            bal -= amt;
            prevTrans = -amt;
            printTransactionSlip("Withdrawal", amt, null);
        } else if (amt > 0) {
            System.out.println("❌ Insufficient balance!");
        } else {
            System.out.println("❌ Invalid withdrawal amount!");
        }
    }

    void getPreviousTrans() {
        if (prevTrans > 0) {
            System.out.println("Last Transaction → Deposited: " + prevTrans);
        } else if (prevTrans < 0) {
            System.out.println("Last Transaction → Withdrawn: " + Math.abs(prevTrans));
        } else {
            System.out.println("No transaction occurred yet.");
        }
    }

    void showAccountDetails() {
        System.out.println("👤 Account Holder: " + customerName);
        System.out.println("🆔 Customer ID   : " + customerId);
        System.out.println("💰 Balance       : " + bal);
    }

    void menu(BankSystem bankSystem) {
        char option;
        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("\n========= MENU =========");
                System.out.println("a) Check Balance");
                System.out.println("b) Deposit Amount");
                System.out.println("c) Withdraw Amount");
                System.out.println("d) Previous Transaction");
                System.out.println("e) Show Account Details");
                System.out.println("f) Transfer Money");
                System.out.println("g) Exit");
                System.out.println("========================");
                System.out.print("👉 Choose an option: ");
                option = sc.next().charAt(0);

                switch (option) {
                    case 'a':
                        System.out.println("💰 Balance = " + bal);
                        break;
                    case 'b':
                        System.out.print("Enter amount to deposit: ");
                        double amt = sc.nextDouble();
                        deposit(amt);
                        bankSystem.saveAccounts();
                        break;
                    case 'c':
                        System.out.print("Enter amount to withdraw: ");
                        double amtW = sc.nextDouble();
                        withdraw(amtW);
                        bankSystem.saveAccounts();
                        break;
                    case 'd':
                        getPreviousTrans();
                        break;
                    case 'e':
                        showAccountDetails();
                        break;
                    case 'f':
                        System.out.print("Enter Receiver ID: ");
                        String receiverId = sc.next();
                        System.out.print("Enter Amount to Transfer: ");
                        double transferAmt = sc.nextDouble();

                        BankAccount receiver = bankSystem.getAccountById(receiverId);
                        if (bankSystem.transferMoney(customerId, receiverId, transferAmt) && receiver != null) {
                            printTransactionSlip("Transfer", transferAmt, receiver.customerName);
                        }
                        break;
                    case 'g':
                        System.out.println("👋 Thank you for using our banking services!");
                        break;
                    default:
                        System.out.println("❌ Invalid option! Try again.");
                        break;
                }
            } while (option != 'g');
        }
    }
}
