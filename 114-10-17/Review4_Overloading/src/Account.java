//Overloading  example in Accountclassb vwith deposit methods
//

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
        this.accountNumber = accountNumber;
        try{
            this.balance = initialBalance;
        }catch (IllegalArgumentException e){
            System.out.println("初始餘額錯誤:"+ e.getMessage()+"餘額設為0");
        }

    }

    public Account()
    {
        this.accountNumber = "000000";
        this.balance = 0.0;
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
     * @throws IllegalArgumentException 若 balance <= 0
     */
    @SuppressWarnings("unused")
     public void setBalance(double balance) {
         if (balance > 0) {
             this.balance = balance; // 增加餘額
         } else {
             throw new IllegalArgumentException("存款金額必須為正");
         }
     }
    @SuppressWarnings("unused")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;


    }



    /**
     *
     * @param amount 存款金額
     * @throws IllegalArgumentException 若 amount <= 0
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
         * @param currency 貨幣類型（如 "USD", "EUR", "JPY"）
         */

    }


    public void deposit (double amount, String currency) {
        double exchangeRate;
        switch (currency) {
            case "USD":
                exchangeRate = 30.0; // 假設 1 USD = 30 TWD
                break;
            case "EUR":
                exchangeRate = 35.0; // 假設 1 EUR = 35 TWD
                break;
            case "JPY":
                exchangeRate = 0.28; // 假設 1 JPY = 0.28 TWD
                break;
            default:
                throw new IllegalArgumentException("不支援的貨幣類型");
        }
        double amountInTWD = amount * exchangeRate;
        if (amountInTWD > 0) {
            balance += amountInTWD; // 增加餘額
        } else {
            throw new IllegalArgumentException("存款金額必須為正");
        }
    }

    /**
     * 新增：可變參數的 deposit 方法，接受多筆存款並累加。
     * 若任一筆金額不為正數，會丟出 IllegalArgumentException。
     *
     * @param amounts 多筆存款金額
     */
    @SuppressWarnings("unused")
    public void deposit(double... amounts) {
        if (amounts == null || amounts.length == 0) {
            throw new IllegalArgumentException("存款金額必須為正");
        }
        double sum = 0.0;
        for (double a : amounts) {
            if (a <= 0) {
                throw new IllegalArgumentException("存款金額必須為正");
            }
            sum += a;
        }
        balance += sum;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // 減少餘額
        } else {
            throw new IllegalArgumentException("提款金額不合法");
        }
    }
}

