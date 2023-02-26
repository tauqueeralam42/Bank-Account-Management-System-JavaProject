import java.util.Scanner;



class BankDetails {
    private String accountNumber;
    private String userName;
    private int balance;
    Scanner sc = new Scanner(System.in);

    // method to open new account
    public void openAccount() {
        System.out.print("Enter Account No: ");
        accountNumber = sc.next();
        System.out.print("Enter Name: ");
        userName = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextInt();
    }

    // method to display account details
    public void showAccount() {
        System.out.println("Name of account holder: " + userName);
        System.out.println("Account no.: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    // method to deposit money
    public void deposit() {
        int amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextInt();
        balance = balance + amt;
    }

    // method to withdraw money
    public void withdrawal() {
        int amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextInt();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
    }

    // method to search an account number
    public boolean search(String ac_no) {
        if (accountNumber.equals(ac_no)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class BankingManagementSystem {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many number of customers do you want to input? ");
        int n = sc.nextInt();
        BankDetails C[] = new BankDetails[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new BankDetails();
            C[i].openAccount();
        }
        // loop runs until number 5 is not pressed to exit
        int choice;
        do {
            System.out.println("\n ***Banking System Application***\n");
            System.out.println("\n Main Menu \n");
            System.out.println(
                    "1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < C.length; i++) {
                        C[i].showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
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
                        System.out.println("Search failed! Account doesn't exist..!!");
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
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 5:
                    System.out.println("See you soon...");
                    break;
            }
        } while (choice != 5);
    }
}
