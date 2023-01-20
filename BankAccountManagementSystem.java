import java.util.Scanner;

abstract class TransactionResources {
    protected double balance = 0;
    protected double previousTransaction = 0;
}

class Transaction extends TransactionResources {

    Scanner sc = new Scanner(System.in);

    /** Check Balance */
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    /** Deposit */
    public void deposit() {
        System.out.println("Please enter an amount to deposit:");
        double amount = sc.nextDouble();
        balance += amount;
        previousTransaction = amount;
        checkBalance();
    }

    /** Withdraw */
    public void withdraw() {
        System.out.println("Please enter an amount to withdraw:");
        double amount = sc.nextDouble();
        if (balance >= amount) {
            balance -= amount;
            previousTransaction = amount;
            checkBalance();
        }
    }

    /** Previous Transaction */
    public void getPreviousTransaction() {
        if (previousTransaction > 0) System.out.println("Deposited: " + previousTransaction);
        else if (previousTransaction < 0) System.out.println("Withdraw: " + previousTransaction);
        else System.out.println("No transactions to show");
        sc.close();
    }

}

class Account extends TransactionResources {
    Scanner sc = new Scanner(System.in);
    protected String name;
    protected String phone;
    protected String email;
    protected String address;

    /** Create Account */
    public void createAccount() {
        System.out.print("Please enter your Name: ");
        name = sc.nextLine();
        System.out.print("Please enter your Contact Number: ");
        phone = sc.nextLine();
        System.out.print("Please enter your Email: ");
        email = sc.nextLine();
        System.out.print("Please enter your Address: ");
        address = sc.nextLine();
    }

    /** Display Account Info */
    public void accountInfo() {
        System.out.println("Username: " + name);
        System.out.println("Contact Number: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        sc.close();
    }
}

public class BankAccountManagementSys extends Account {

    public static void main(String[] args) {
        Account acc = new Account();
        Transaction t = new Transaction();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("What operation do you want to perform?\n" +
                    "Press 1 to Create new account\n" +
                    "Press 2 to check Account details\n" +
                    "Press 3 to Check Balance\n" +
                    "Press 4 to deposit money\n" +
                    "Press 5 to withdraw money\n" +
                    "Press 0 to EXIT");
            choice = sc.nextInt();
            switch(choice) {
                case 1: acc.createAccount(); break;
                case 2: acc.accountInfo(); break;
                case 3: t.checkBalance(); break;
                case 4: t.deposit(); break;
                case 5: t.withdraw(); break;
                case 0: System.exit(0);
                    System.out.println("Terminating process (Exit code: 0");
                default: System.exit(1);
                    System.out.println("Aborting process (Exit code: 1)");
            }
        } while(choice != 0);

        sc.close();
        System.gc();
    }

}
