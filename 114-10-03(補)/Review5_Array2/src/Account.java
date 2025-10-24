public class Account {
    private static int accountCount = 0;
    private String accountNumber;
    private String ownerName;
    private double balance;

    /**
     * @param accountNumber  explicit account number or null to auto-generate
     * @param initialBalance starting balance (must be >= 0)
     */
    public Account(String accountNumber, String ownerName, double initialBalance) {

        this.setAccountNumber(accountNumber);
        this.ownerName = ownerName;
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤: " + e.getMessage() + "，將餘額預設為0");
        }
        accountCount++;

    }

    // Convenience constructor: owner name + initial balance, auto-generate account number
    public Account(String ownerName, double initialBalance) {
        this("ACC" + (accountCount + 1), ownerName, initialBalance);
    }

    // No-arg constructor: default values, auto-generate account number
    public Account() {
        this("ACC" + (accountCount + 1), "未知", 0);
    }

    // Constructor with only account number: owner unknown, zero balance
    public Account(String accountNumber) {
        this(accountNumber, "未知", 0);
    }

    /**
     *
     * @return
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return
     */

    public double getBalance() {
        return balance;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    // Internal balance setter enforces non-negative balance
    private void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("帳戶餘額必須為非負數");
        }
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     *
     * @param amount
     * @throws IllegalArgumentException
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("存款金額必須為正數");
        }

    }

    /**
     *
     * @param amount
     * @throws IllegalArgumentException
     */

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false; // keep behavior simple: return false on invalid withdraw
        }

    }
}

