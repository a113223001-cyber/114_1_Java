public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.setAccountNumber(accountNumber);
        try{
            this.setBalance(initialBalance);
        }catch (IllegalArgumentException e){
            System.out.println("初始餘額錯誤:"+ e.getMessage()+"，餘額設為0");
            this.balance = 0;
        }

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
        /**
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