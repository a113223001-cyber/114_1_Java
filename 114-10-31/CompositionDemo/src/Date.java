public class Date {
    private int month; // 月份：1-12
    private int day;   // 日期：依月份為 1-31
    private int year;  // 年份：任何年份

    // 各月份的天數（索引 0 不使用）
    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // 建構子：確認輸入的月份與日期在指定年份中是否合法
    public Date(int month, int day, int year) {
        // 檢查月份是否在有效範圍內
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException(
                    "月份（" + month + "）必須介於 1 到 12 之間");
        }

        // 檢查日期是否在該月份的有效範圍內
        if (day <= 0 ||
                (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException("日期（" + day +
                    "）超出該月份與年份的有效範圍");
        }

        // 若為 2 月 29 日，需確認是否為閏年
        if (month == 2 && day == 29 && !(year % 400 == 0 ||
                (year % 4 == 0 && year % 100 != 0))) {
            throw new IllegalArgumentException("日期（" + day +
                    "）超出該月份與年份的有效範圍（非閏年）");
        }

        this.month = month;
        this.day = day;
        this.year = year;

        //System.out.printf("建立日期物件：%s%n", this);
    }

    // 回傳字串格式：月/日/年
    public String toString() {

        return String.format("%d/%d/%d", month, day, year);
    }
}