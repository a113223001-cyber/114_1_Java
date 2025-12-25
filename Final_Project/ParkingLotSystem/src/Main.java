import system.ParkingManager;
import system.ParkingFloor;
import system.MemberManager;
import model.*;
import strategy.*;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
        ParkingManager manager = new ParkingManager(); // 停車場管理系統
        MemberManager memberManager = new MemberManager();
        Scanner sc = new Scanner(System.in);
        PricingStrategy strategy = new HourlyPricing();

        while (true) {
            System.out.println("\n--- 智慧停車場 車輛進場/車輛離場結帳/查看停車場現況/退出系統  控制系統 ---");
            System.out.println("1. 車輛進場 (Park)");
            System.out.println("2. 車輛離場結帳 (Exit & Pay)");
            System.out.println("3. 查看停車場現況 (Status)");
            System.out.println("4. 退出系統 (Close)");
            System.out.print("請輸入選項: ");
            int choice = sc.nextInt();
            sc.nextLine();



            switch (choice) {

                case 1:// 車輛進場

                    // --- 即時看板 ---
                    System.out.println("\n===== 門口即時車位看板 =====");
                    System.out.printf("機車位(Motor): %d | 標準位(Standard): %d | 大型位(Large): %d| 電動車位: %d\n",
                            manager.getAvailableCountByType("Motor"),
                            manager.getAvailableCountByType("Standard"),
                            manager.getAvailableCountByType("Large"),
                            manager.getAvailableCountByType("EV"));
                    System.out.println("============================");


                    // 2. 詢問會員身分
                    System.out.print("\n您是否為本場會員？ (是請按 1，否請按 0): ");
                    int isMemberInput = sc.nextInt();
                    sc.nextLine();


                    String plate = getValidPlate(sc); // 防空值輸入檢查

                    if (manager.isPlateAlreadyParked(plate)) {
                        System.out.println("錯誤：此車牌已在場內。");
                        break;
                    }

                    // 3. 驗證會員身分
                    if (isMemberInput == 1) {
                        if (memberManager.isMember(plate)) {
                            model.Member m = memberManager.getMember(plate);
                            System.out.println("【 驗證成功！歡迎 " + m.getMemberType() + " 會員：" + m.getName() + " 】");
                        } else {
                            System.out.println("【 驗證失敗：找不到您的會員資料，將以一般費率計費 】");
                        }
                    } else {
                        System.out.println("（使用一般費率計費）");
                    }

                    // 選擇車種
                    System.out.println("請選擇車種：1.機車 2.轎車 3.休旅車 4.貨車 5.電動車");
                    System.out.print("選擇：");
                    int typeChoice = sc.nextInt();
                    sc.nextLine();

                    Vehicle v;
                    switch (typeChoice) {
                        case 1: v = new Motorcycle(plate); break;// 機車
                        case 2: v = new Sedan(plate); break;// 轎車
                        case 3: v = new SUV(plate); break;// 休旅車
                        case 4: v = new Truck(plate); break;// 貨車
                        case 5: v = new ElectricCar(plate); break; // 電動車
                        default:
                            System.out.println("無效選擇，預設為轎車");
                            v = new Sedan(plate);
                    }

                    // 貨車會回傳 List<ParkingSpot>，一般車回傳 ParkingSpot
                    Object result = manager.findEmptySpot(v);

                    if (result == null) {
                        System.out.println("抱歉，適合該車種的空位不足！");
                    }
                    // 判斷是否為「貨車的位子清單」貨車會回傳 List<ParkingSpot>，一般車回傳 ParkingSpot
                    else if (result instanceof java.util.List) {
                        // 貨車：佔用兩個位子
                        @SuppressWarnings("unchecked")
                        java.util.List<ParkingSpot> truckSpots = (java.util.List<ParkingSpot>) result;
                        for (ParkingSpot s : truckSpots) {
                            s.park(v); // 讓兩個位子都進入「已停車」狀態
                        }
                        System.out.println("貨車停車成功！已合併兩個【標準位】：" +
                                truckSpots.get(0).getSpotId() + " 與 " + truckSpots.get(1).getSpotId());
                    } else {
                        //  機車、轎車、休旅車 (都是單一格位)
                        ParkingSpot emptySpot = (ParkingSpot) result;
                        emptySpot.park(v);

                        String spotInfo = "";
                        if (v instanceof SUV) spotInfo = "大型車位";
                        else if (v instanceof Sedan) spotInfo = "標準車位";
                        else spotInfo = "機車位";

                        System.out.println(v.getType() + "停車成功！停入 " + spotInfo + "：" + emptySpot.getSpotId());
                    }
                    break;
                case 2: // 車輛離場與結帳
                    String exitPlate = getValidPlate(sc); // 防空值輸入檢查
                    // 使用 manager 提供的功能尋找車位
                    ParkingSpot foundSpot = manager.findSpotByPlate(exitPlate);

                    if (foundSpot != null) {
                        // --- 會員身分檢查 ---
                        boolean isVIP = memberManager.isMember(exitPlate);
                        // 取得時間差
                        Duration duration = Duration.between(foundSpot.getStartTime(), LocalDateTime.now());

                        // 指定使用累進計費策略
                        // 使用 main 裡已宣告的 strategy
                        double fee = strategy.calculateFee(duration, foundSpot.getParkedVehicle());


                        // 會員享有 8 折優惠
                        double originalFee = fee; // 紀錄原始金額
                        if (isVIP) {
                            fee *= 0.8;
                            System.out.println("尊貴的會員客戶，您享有 8 折優惠！");
                        }

                        // 3. 定義顯示格式
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                        // 5. 顯示詳細結帳資訊
                        System.out.println("\n--- 智慧停車場 結帳單 ---");
                        System.out.println("車牌號碼：" + exitPlate);

                        // --- 會員資訊顯示---
                        if (isVIP) {
                            model.Member m = memberManager.getMember(exitPlate);
                            System.out.println("【 尊榮會員：" + m.getName() + " (已享 8 折優惠) 】");
                            System.out.println("原始費用：" + originalFee + " 元");
                        }

                        // 4. 結帳資訊
                        System.out.println("計費說明：" + strategy.getDescription());
                        System.out.println("停車時數：" + (duration.toHours() + 1) + " 小時 (含未滿1小時進位)");
                        System.out.println("應付總額：" + fee + " 元");

                        //一次清空該車牌佔用的所有位子
                        manager.releaseAllSpotsByPlate(exitPlate);

                        // 5. 離場 (清空車位)

                        System.out.println("繳費成功，車位已釋出。祝您順風！");
                        System.out.println("離場時間: " + LocalDateTime.now().format(formatter));

                    } else {
                        System.out.println("系統找不到這台車 (車牌: " + exitPlate + ")，請確認是否輸入正確。");
                    }
                    break;


                case 3:
                    System.out.println("\n--- 停車場即時狀況 (分層顯示) ---");
                    // 顯示所有樓層與車位狀態
                    // 說明：此選項會列出每一樓層（例如 B1、B2），並顯示該樓層每個車位的狀態。
                    //       若車位為空則顯示 "空"，否則顯示停放車輛的車牌號碼。
                    // 使用：透過 ParkingManager.getFloors() 取得樓層清單，並由 ParkingFloor.getSpots() 取得每層的車位清單.

                    // 總計變數，避免未宣告錯誤
                    int totalSpots = 0;
                    int totalOccupied = 0;


                    for (ParkingFloor floor : manager.getFloors()) {// 逐層顯示
                        int floorTotal = floor.getSpots().size();
                        int floorOccupied = 0;
                        for (ParkingSpot s : floor.getSpots()) {// 計算已停車位數
                            if (!s.isEmpty()) floorOccupied++;
                        }
                        totalSpots += floorTotal;
                        totalOccupied += floorOccupied;

                        System.out.println("\n【 樓層：" + floor.getFloorName() + " （已停 " + floorOccupied + " / " + floorTotal + "）】");
                        for (ParkingSpot s : floor.getSpots()) {
                            String info = s.isEmpty() ? "空" : s.getParkedVehicle().getPlate();
                            System.out.println("  " + s.getSpotId() + " : " + info);
                        }
                    }

                    // --- 總計的部分，詳細分類統計 ---
                    System.out.println("\n========= 全場統計總覽 =========");
                    System.out.println("小型機車位：剩餘 " + manager.getAvailableCountByType("Motor") + " 格");
                    System.out.println("標準轎車位：剩餘 " + manager.getAvailableCountByType("Standard") + " 格");
                    System.out.println("大型貨車位：剩餘 " + manager.getAvailableCountByType("Large") + " 格");
                    System.out.println("電動車位：剩餘 " + manager.getAvailableCountByType("EV") + " 格");
                    System.out.println("\n總計：已停 " + totalOccupied + " / " + totalSpots + " 車位\n");
                    break;

                case 4:
                    return;
            }
        }
    }

    //集中處理車牌輸入的檢查，不能為空，也不能只是空白
    private static String getValidPlate(Scanner sc) {
        String plate;
        while (true) {
            System.out.print("請輸入車牌號碼: ");
            plate = sc.nextLine().trim();
            if (plate.isEmpty()) {
                System.out.println("錯誤：車牌不可為空或空白，請重新輸入！");
                continue;
            }
            // 檢查是否為空/空白
            return plate;
        }
    }
}