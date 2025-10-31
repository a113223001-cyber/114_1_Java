import java.util.Scanner;
import java.util.ArrayList;

   public class AccountTest {
   public static void main(String[] ignored) {
        ArrayList<Account> customers = new ArrayList<>();
        Account acc1 = new Account("A001", "Alice", "A33333333",5000);
        addCustomer(customers, acc1);
        Account acc2 = new Account("A002", "Bob", "B11111111",3000);
        addCustomer(customers, acc2);
        Account acc3 = new Account("A003", "Charlie","C55555555", -100);
        addCustomer(customers, acc3);

        operation(customers);
    }

    public static void operation(ArrayList<Account> customers) {
        Scanner scanner = new Scanner(System.in);
        Account selectedAccount;
        int choice;
        do {
            meau();
            System.out.print("請選擇功能(1-7): ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("請輸入帳戶號碼: ");
                    String accountNumber = scanner.next();
                    System.out.print("請輸入客戶姓名: ");
                    String ownerName = scanner.next();
                    System.out.print("請輸入初始餘額: ");
                    double initialBalance = scanner.nextDouble();
                    Account newAccount = new Account(accountNumber, ownerName, initialBalance);
                    addCustomer(customers, newAccount);
                    break;
                case 2:
                    System.out.println("請輸入要查詢的帳戶號碼: ");
                    String searchAccountNum = scanner.next();
                    selectedAccount = customerInAction(customers, searchAccountNum);
                    printCustomerInfo(selectedAccount);

                    break;
                case 3:
                    System.out.println("\n所有客戶帳戶資訊:");
                    printCustomerAccounts(customers);
                    break;
                case 4:
                    System.out.print("請輸入要刪除的帳戶號碼: ");
                    String deleteAccountNum = scanner.next();
                    deleteCustomer(customers, deleteAccountNum);
                    break;
                case 5:
                    System.out.println("離開系統，謝謝使用!");
                    break;

                case 6:
                    System.out.print("請輸入帳戶號碼以進行存款: ");
                    String depAccNum = scanner.next();
                    Account depAcc = customerInAction(customers, depAccNum);
                    if (depAcc != null) doDeposit(depAcc, scanner);
                    break;

                case 7:
                    System.out.print("請輸入帳戶號碼以進行提款: ");
                    String witAccNum = scanner.next();
                    Account witAcc = customerInAction(customers, witAccNum);
                    if (witAcc != null) doWithdraw(witAcc, scanner);
                    break;

                default:
                    System.out.println("無效的選擇，請重新輸入。");
            }
        } while (choice != 5);
    }

       //  存款方法
       public static void doDeposit(Account acc, Scanner scanner) {
           System.out.print("請輸入存款金額: ");
           double amount = scanner.nextDouble();
           try {
               acc.deposit(amount);
               System.out.printf("成功存入 %.2f 元。當前餘額：%.2f 元%n", amount, acc.getBalance());
           } catch (IllegalArgumentException e) {
               System.out.println(" 存款失敗：" + e.getMessage());
           }
       }

       //  提款方法
       public static void doWithdraw(Account acc, Scanner scanner) {
           System.out.print("請輸入提款金額: ");
           double amount = scanner.nextDouble();
           try {
               acc.withdraw(amount);
               System.out.printf("✅ 成功提取 %.2f 元。當前餘額：%.2f 元%n", amount, acc.getBalance());
           } catch (IllegalArgumentException e) {
               System.out.println(" 提款失敗：" + e.getMessage());
           }
       }


       public static Account customerInAction(ArrayList<Account> customers, String accountNumber) {
        for (Account customer : customers) {
            if (customer.getAccountNumber().equals(accountNumber)) {
                return customer;
            }
        }
        System.out.println("找不到指定的帳戶號碼: " + accountNumber);
        return null;
    }

    public static void addCustomer(ArrayList<Account> customers, Account newAccount) {
        customers.add(newAccount);
        System.out.println("成功新增客戶: " + newAccount.getAccountNumber());
    }

    public static void deleteCustomer(ArrayList<Account> customers, String accountNumber) {
        Account accountToRemove = customerInAction(customers, accountNumber);
        if (accountToRemove != null) {
            customers.remove(accountToRemove);
            System.out.println("成功刪除帳戶: " + accountToRemove.getAccountNumber()+"("+accountToRemove.getOwnerName()+")");
        }
    }

    public static void printCustomerAccounts(ArrayList<Account> customers) {
        for (Account customer : customers) {
            printCustomerInfo(customer);
        }
    }

    public static void printCustomerInfo(Account account) {
        if(account == null) {
            System.out.println("無法列印客戶資訊，帳戶不存在。");
           return;
       }
        System.out.println(account.toString());

    }
//功能選單(1) 新增客戶 (2)列印指定客戶帳戶資訊 (3)顯示所有客戶帳戶資訊 (4)刪除客戶帳戶 (5)離開
    public static void meau() {
        System.out.println("功能選單:");
        System.out.println("(1)新增客戶");
        System.out.println("(2)列印指定客戶帳戶資訊");
        System.out.println("(3)顯示所有客戶帳戶資訊");
        System.out.println("(4)刪除客戶帳戶");
        System.out.println("(5) 離開");
        System.out.println("(6) 存款");
        System.out.println("(7) 提款");
    }
}