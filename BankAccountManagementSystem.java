import java.util.Scanner;
import java.util.ArrayList;


class BankDetails {
    private String accountNumber;
    private String userName;
    private int balance;
    private ArrayList<Transaction> transactions;
    Scanner sc = new Scanner(System.in);

    public BankDetails() {
        transactions = new ArrayList<Transaction>();
    }

    public void openAccount() {
        System.out.print("Enter Account No: ");
        accountNumber = sc.next();
        System.out.print("Enter Name: ");
        userName = sc.nextLine();
        userName = sc.nextLine();
        System.out.print("Enter Balance: ");
        balance = sc.nextInt();
    }

    public void showAccount() {
        System.out.println("Name of account holder: " + userName);
        System.out.println("Account no.: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("--------------------------------------------");

    }

    public void showTransactionHistory() {
        int i = 1;
        for (Transaction t : transactions) {
            System.out.print("Transaction no. " + i + ": ");
            System.out
                    .println("  Type: " + t.getType() + ", Amount: " + t.getAmount() + ", Balance: " + t.getBalance());
            i++;
        }
    }

    public void deposit() {
        int amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextInt();
        balance = balance + amt;
        System.out.println("The Amount is Deposited Successfully and Your new balance is : " + balance);
        transactions.add(new Transaction("Deposit", amt, balance));
    }

    public void withdrawal() {
        int amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextInt();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Your Withdrawal is Successful and New Balance after withdrawal is : " + balance);
            transactions.add(new Transaction("Withdrawal", amt, balance));
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
    }

    public boolean search(String ac_no) {
        if (accountNumber.equals(ac_no)) {
            System.out.println("--- The Bank Account details of Account no. " + ac_no + ":  ---");
            showAccount();
            return (true);
        }
        return (false);
    }
}

class Transaction {
    private String type;
    private int amount;
    private int balance;

    public Transaction(String type, int amount, int balance) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalance() {
        return balance;
    }
}


public class BankingManagementSystem {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many number of customers do you want to input? ");
        int n = sc.nextInt();
        BankDetails C[] = new BankDetails[n];
        System.out.println("--------------------------------------------");
        for (int i = 0; i < C.length; i++) {
            System.out.println("--- Enter the Bank Account details of Customer " + (i + 1) + ":  ---");
            C[i] = new BankDetails();
            C[i].openAccount();
            System.out.println("--------------------------------------------");
        }

        int choice;
        do {
            System.out.println("\n *** Banking System Application ***");
            System.out.println("             Main Menu \n");
            System.out.println(
                    " 1.Display all account details \n 2.Search by Account number\n 3.Deposit the amount \n 4.Withdraw the amount \n 5.Transaction History \n 6.Exit\n");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("--------------------------------------------");
                    for (int i = 0; i < C.length; i++) {
                        System.out.println("--- Bank Account details of Customer " + (i + 1) + ": ---");
                        C[i].showAccount();

                    }
                    break;
                case 2:
                    System.out.print("Enter Account no. you want to search: ");
                    String ac_no = sc.next();
                    System.out.println("--------------------------------------------");
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("--------------------------------------------");
                        System.out.println("Search failed! Account doesn't exist..!!");
                        System.out.println("--------------------------------------------");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("--------------------------------------------");
                        System.out.println("Search failed! Account doesn't exist....!!");
                        System.out.println("--------------------------------------------");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            System.out.println("--- The Transaction details of Account no. " + ac_no + ":  ---");
                            C[i].showTransactionHistory();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("--------------------------------------------");
                        System.out.println("Search failed! Account doesn't exist....!!");
                        System.out.println("--------------------------------------------");
                    }
                    break;
                case 6:
                    System.out.println("See you soon.....");
                    break;
            }
        } while (choice != 6);
    }
}
