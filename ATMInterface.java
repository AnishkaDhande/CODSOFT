import java.util.Scanner;

// class of the user bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: ₹ " + amount);
        } else {
            System.out.println("Invalid deposit amount. Try again.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: ₹ " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount. Try again.");
        }
    }
}

// class of ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\n===== ATM Options =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹ " + account.getBalance());
    }

    public void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ₹ ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    public void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ₹ ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    public void startATM() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM...!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}

// Main class
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00); // Initialize account with ₹1000
        ATM atm = new ATM(userAccount);
        atm.startATM();
    }
}
