class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds. Cannot withdraw.");
        }
    }

    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}


public class Task1  {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Srinuvasu", "1234567890", 1000);
        account.displayBalance(); 
        
        account.deposit(500.0);
        account.displayBalance(); 
        
        account.withdraw(200.0);
        account.displayBalance(); 
        
        account.withdraw(1500.0); 
    }
}