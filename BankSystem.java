import java.io.*;
import java.util.*;

public class BankSystem {
    private Map<String, BankAccount> accounts = new HashMap<>();
    private final String fileName = "users.txt";
    private int lastId = 1000; // starting point for IDs

    public BankSystem() {
        loadAccounts();
    }

    // Get account by ID
    public BankAccount getAccountById(String id) {
        return accounts.get(id);
    }

    // Create new account
    public BankAccount createAccount(String name, String id) {
        if (accounts.containsKey(id)) {
            System.out.println("❌ Error: Customer ID already exists!");
            return null;
        }
        BankAccount acc = new BankAccount(name, id, 0.0);
        accounts.put(id, acc);
        saveAccounts();
        return acc;
    }

    // Generate unique Bank ID
    public String generateNewId() {
        lastId++;
        return "BANK" + lastId;
    }

    // Save accounts to file
    public void saveAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (BankAccount acc : accounts.values()) {
                writer.write(acc.customerName + "," + acc.customerId + "," + acc.bal);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error saving accounts: " + e.getMessage());
        }
    }

    // Load accounts from file
    public void loadAccounts() {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0];
                    String id = data[1];
                    double balance = Double.parseDouble(data[2]);
                    accounts.put(id, new BankAccount(name, id, balance));

                    // Update lastId
                    if (id.startsWith("BANK")) {
                        try {
                            int num = Integer.parseInt(id.substring(4));
                            if (num > lastId) lastId = num;
                        } catch (NumberFormatException ignore) {}
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error loading accounts: " + e.getMessage());
        }
    }

    // Transfer money
    public boolean transferMoney(String senderId, String receiverId, double amount) {
        BankAccount sender = accounts.get(senderId);
        BankAccount receiver = accounts.get(receiverId);

        if (sender == null || receiver == null) {
            System.out.println("❌ Invalid sender or receiver ID!");
            return false;
        }

        if (sender.bal >= amount) {
            sender.withdraw(amount);
            receiver.deposit(amount);
            saveAccounts();
            System.out.println("💸 Transfer successful! " + amount + " sent to " + receiver.customerName);
            return true;
        } else {
            System.out.println("❌ Insufficient balance for transfer!");
            return false;
        }
    }
}
