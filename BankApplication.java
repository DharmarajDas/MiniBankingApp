import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankSystem bankSystem = new BankSystem();

        System.out.println("===================================");
        System.out.println("   🏦 Welcome to Mini Banking App   ");
        System.out.println("===================================");

        System.out.print("👉 Enter your Customer ID (or type 'new' to create account): ");
        String input = sc.nextLine().trim();

        if (input.equalsIgnoreCase("new")) {
            System.out.print("✨ Enter your Name: ");
            String name = sc.nextLine();

            String newId = bankSystem.generateNewId();
            BankAccount account = bankSystem.createAccount(name, newId);

            if (account != null) {
                System.out.println("\n===================================");
                System.out.println("          🏦 MINI BANK ATM         ");
                System.out.println("===================================");
                System.out.println("🎉 Account Created Successfully!");
                System.out.println("-----------------------------------");
                System.out.println("👤 Account Holder : " + name);
                System.out.println("🆔 Customer ID    : " + newId);
                System.out.println("💰 Starting Balance : 0.0");
                System.out.println("-----------------------------------");
                System.out.println("✨ Please remember your Customer ID.");
                System.out.println("===================================\n");

                account.menu(bankSystem);
            }
        } else {
            BankAccount account = bankSystem.getAccountById(input);

            if (account != null) {
                System.out.println("✅ Welcome back, " + account.customerName + "!");
                account.menu(bankSystem);
            } else {
                System.out.println("❌ No account found with ID: " + input);
                System.out.println("👉 Please type 'new' next time to create a fresh account.");
            }
        }

        sc.close();
    }
}
