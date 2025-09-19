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
    public double getBalance() {
        return balance;
    }
}
