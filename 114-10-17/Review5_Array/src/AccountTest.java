public class AccountTest {
    private static int testCount;

    public static void main(String[] args) {
        Account[] customers = new Account[10];
        customers[0] = new Account("A001", 1000);
        customers[1] = new Account("A002", 2000);
        customers[2] = new Account("A003", -500); // 初始餘額錯誤

    }

    public static void addTestCount(Account[] customers ) {
        testCount++;
    }

    public static int getTestCount() {
        return testCount;
    }
    public static void resetTestCount() {
        testCount = 0;
    }



}