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


            // Use the accounts so IDE/compiler won't warn about unused variables
            System.out.println("\n所有位客戶帳戶資訊:");
            printCustomerAccounts(customers);
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
            System.out.println("帳戶號碼: " + account.getAccountNumber() +
                    ", 客戶姓名: " + account.getOwnerName() +
                    ", 帳戶餘額: " + account.getBalance());
        }
    }