import java.util.*;

class BankDetails {
    private String accountNumber;
    private String userName;
    private int balance;
    Scanner sc = new Scanner(System.in);
    
    public void openAccount() {
        System.out.print("Enter Account No: ");
        accountNumber = sc.next();
        System.out.print("Enter Name: ");
        userName = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextInt();
    }
    
    public void showAccount() {
        System.out.println("Name of account holder: " + userName);
        System.out.println("Account no.: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
    
    public void deposit() {
        int amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextInt();
        balance = balance + amt;
    }
    
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
    
}
    
    
public class BankAccountManagementSys {
    public static void main(String[] args) {
        
        
    }
}
