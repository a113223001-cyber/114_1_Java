public class Account {
    // 私有成員變數，儲存帳戶號碼
    private String accountNumber;
    // 私有成員變數，儲存帳戶餘額
    private double balance;

    /**
     * 帳戶建構子，初始化帳戶號碼和初始餘額
     *
     * @param accountNumber  帳戶號碼
     * @param initialBalance 初始餘額
     */
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber; // 設定帳戶號碼
        this.balance = initialBalance;     // 設定初始餘額
    }

    /**
     * 獲取帳戶號碼
     *
     * @return 帳戶號碼
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 獲取帳戶餘額
     *
     * @return 帳戶餘額
     */
    public double getBalance()
    {
        return balance;
    }
    /**
     * 設定帳戶餘額
     *
     * @param balance 帳戶餘額
     * @throws IllegalArgumentException
     */
    public void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance; // 增加餘額
        } else {
            throw new IllegalArgumentException("存款金額必須為正");
        }
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     *
     * @param amount 存款金額
     * @throws  IllegalArgumentException
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // 增加餘額
        } else {
            throw new IllegalArgumentException("存款金額必須為正");
        }
        /*
         *
         * @param amount 存款金額
         * @
         * @throws IllegalArgumentException
         */
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // 減少餘額
        } else {
        throw new IllegalArgumentException("提款金額不合法");
        }
    }
}
