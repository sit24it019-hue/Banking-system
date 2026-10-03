import java.util.Scanner;

class BankAccount {
    private String name;
    private long accountNumber;
    private double balance;

    BankAccount(String name, long accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("amount deposited successfully.");
        } else {
            System.out.println("invalid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("amount withdrawn successfully.");
        } else {
            System.out.println("insufficient balance or invalid amount.");
        }
    }

    void showBalance() {
        System.out.println("account holder : " + name);
        System.out.println("account number : " + accountNumber);
        System.out.println("balance        : ₹" + balance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("enter account number: ");
        long accountNumber = sc.nextLong();

        System.out.print("enter initial balance: ");
        double balance = sc.nextDouble();

        BankAccount account =
                new BankAccount(name, accountNumber, balance);

        int choice;

        do {
            System.out.println("\n===== banking management system =====");
            System.out.println("1. deposit");
            System.out.println("2. withdraw");
            System.out.println("3. check balance");
            System.out.println("4. exit");
            System.out.print("enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;

                case 2:
                    System.out.print("enter withdrawal amount: ");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;

                case 3:
                    account.showBalance();
                    break;

                case 4:
                    System.out.println("thank you for using banking system.");
                    break;

                default:
                    System.out.println("invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}