import java.util.Scanner;

public class AccountTest {
    private static int customerCount;
    ;

    public static void main(String[] args) {
        Account[] customers = new Account[10];
        Account acc1 = new Account("A001", "Alice", 5000);
        addCustomer(customers, acc1);
        Account acc2 = new Account("A002", "Bob", 3000);
        addCustomer(customers, acc2);
        Account acc3 = new Account("A003", "Charlie", -100);
        addCustomer(customers, acc3);

        operation(customers);
        // 顯示所有客戶帳戶資訊
        //System.out.println("\n所有位客戶帳戶資訊:");
        // printCustomerAccounts(customers);
    }

    public static void operation(Account[] customers) {
        Scanner scanner = new Scanner(System.in);
        Account selectedAccount = null;
        int choice;
        do {
            meau();
            System.out.print("請選擇功能(1-3): ");
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
                        selectedAccount=customerInAction(customers,searchAccountNum);
                        printCustomerInfo(selectedAccount);

                        break;
                case 3:
                    System.out.println("\n所有位客戶帳戶資訊:");
                    printCustomerAccounts(customers);
                    break;
                case 4:
                    System.out.println("離開系統，謝謝使用!");
                    break;
                default:
                    System.out.println("無效的選擇，請重新輸入。");
            }
        } while (choice != 4);

    }
    public static Account customerInAction(Account[] customers, String accountNumber) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getAccountNumber().equals(accountNumber)) {
                return customers[i];
            }
        }
        System.out.println("找不到指定的帳戶號碼: " + accountNumber);
        return null;
    }

    public static void addCustomer(Account[] customers, Account newAccount) {
        if (customerCount < customers.length) {
            customers[customerCount] = newAccount;
            customerCount++;
            System.out.println("成功新增客戶: " + newAccount.getAccountNumber());
        }
        System.out.println("無法新增客戶，客戶數量已達上限");
    }

    public static void printCustomerAccounts(Account[] customers) {
        for (int i = 0; i < customerCount; i++) {
            printCustomerInfo(customers[i]);
        }
    }

    public static void printCustomerInfo(Account account) {
        if(account==null){
            System.out.println("無法列印客戶資訊，帳戶不存在。");
            return;
        }
        System.out.println("帳戶號碼: " + account.getAccountNumber() +
                ", 客戶姓名: " + account.getOwnerName() +
                ", 帳戶餘額: " + account.getBalance());
    }

    //功能選單(1)新增客戶(2)列印指定客戶帳戶資訊(3)顯示所有客戶帳戶資訊(4)離開
    public static void meau() {
        System.out.println("功能選單:");
        System.out.println("(1)新增客戶");
        System.out.println("(2)列印指定客戶帳戶資訊");
        System.out.println("(3)顯示所有客戶帳戶資訊");
        System.out.println("(4)離開");
    }
}