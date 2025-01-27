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
            System.out.printf("Deposit successful. New balance: %.2f%n", balance);
        } else {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.0");
        }
    }

    public void deposit(double amount, String transactionalNote) {
        if(amount > 0.0){
            balance += amount;
            System.out.printf("Transaction note: %s%n", transactionalNote);
            System.out.printf("New balance: %.2f%n", balance);
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
            System.out.printf("Withdrawal successful. New balance: %.2f%n", balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void displayAccountDetails() {
        System.out.println(accountHolderName);
        System.out.println(accountNumber);
        System.out.println(balance);
    }

    public static void main(String[] args) {
        BankAccount accountHolder1 = new savingsAccount("Asampong Godswill", "497634583453", 500.00, 3);

        BankAccount accountHolder2 = new currentAccount("Ukpel Derrick", "327469823647327", 1000.00, 500.00);

        accountHolder1.deposit(300.00);
        accountHolder2.deposit(250.00);

        accountHolder1.deposit(450.00, "Salary Deposit");
        accountHolder2.deposit(700.00, "Payment for service");

        accountHolder1.withdrawal(450.00);
        accountHolder2.withdrawal(550.00);
    }
}

class savingsAccount extends BankAccount {
    private double interestRate;
    
    public savingsAccount(String accountHolderName, String accountNumber, double balance, double interestRate) {
        super(accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * (interestRate / 100) * 12;
    }

    @Override
    public void displayAccountDetails(){
        super.displayAccountDetails();
        System.out.println(interestRate);
    }

    @Override
    public void withdrawal(double amount) {
        if(getBalance() - amount >= 100) {
            super.withdrawal(amount);
        } else {
            throw new IllegalArgumentException("Minimum balance requirement not met.");
        }
    }
}

class currentAccount extends BankAccount {
    private double overdraftLimit;

    public currentAccount(String accountHolderName, String accountNumber, double balance, double overdraftLimit){
        super(accountHolderName, accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void displayAccountDetails(){
        super.displayAccountDetails();
        System.out.println(overdraftLimit);
    }

    @Override
    public void withdrawal(double amount) {
        if(super.getBalance() < overdraftLimit) {
            super.withdrawal(amount);
        } else {
            throw new IllegalArgumentException("Overdraft limit exceeded.");
        }
    }
}
