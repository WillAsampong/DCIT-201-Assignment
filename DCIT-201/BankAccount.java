public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double balance){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        setBalance(balance);
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0.0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.0");
        }
    }

    public void deposit(double amount, String transactionalNote) {
        if(amount > 0.0){
            balance += amount;
            System.out.printf("Transaction note: %s%n", transactionalNote);
            System.out.println("New balance: " + balance);
        } else {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.0");
        }
    }

    public void withdrawal(double amount) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0.0");
        }

        if(amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public static void main(String[] args) {
        try{
            BankAccount accountholder1 = new BankAccount("Ukpel Derrick", "324360537237", 1000000.00);

            accountholder1.deposit(700.00);
            accountholder1.deposit(850.00, "Salary Deposit");

            accountholder1.withdrawal(500.00);



        } catch(Exception e) {
            System.err.println("Error message: " + e.getMessage());
        }
    }
}


