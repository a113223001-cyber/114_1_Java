public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account("A123", 1000);
        Account account2 = new Account("B456", 2000);
        Account account3 = new Account();
        System.out.printf("帳戶號碼:%s%n存款後餘額:%.2f%n", account1.getAccountNumber(), account1.getBalance());
        System.out.printf("帳戶號碼:%s%n存款後餘額:%.2f%n", account2.getAccountNumber(), account2.getBalance());

        account1.deposit(1000.0);
        System.out.printf("帳戶號碼:%s%n存款後餘額:%.2f%n", account1.getAccountNumber(), account1.getBalance());

       /* try {
            account1.withdraw(-100.0);
            System.out.printf("帳戶號碼:%s%n提款後餘額:%.2f%n", account1.getAccountNumber(), account1.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("提款錯誤:"+ e.getMessage());
            account1.withdraw(100.0, "USD");


            System.out.println("提款錯誤:" + e.getMessage());
        account2.deposit(amounts: 200.0, 300.0, 400.0);
        System.out.printf("帳戶號碼:%s%n存款後餘額:%.2f%n", account2.getAccountNumber(), account2.getBalance());
        try {
            account2.deposit(1000.0, 2000.0, 5000.0);
            System.out.printf("帳戶號碼:%s%n存款後餘額:%.2f%n", account2.getAccountNumber(), account2.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("存款錯誤:" + e.getMessage());
        }
    }
