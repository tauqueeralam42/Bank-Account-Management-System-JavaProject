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
    
}
    
    
public class BankAccountManagementSys {
    public static void main(String[] args) {
        
        
    }
}
