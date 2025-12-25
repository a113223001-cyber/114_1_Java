package system;

import model.ParkingSpot;
import model.RegularSpot;
import java.util.ArrayList;
import java.util.List;

/**
 * ParkingFloor represents a parking floor (e.g. "B1", "B2") and its spots.
 * 提供建立車位與尋找空位的簡單工具方法。
 */
public class ParkingFloor {
    private String floorName; // "B1" 或 "B2"
    private List<ParkingSpot> spots = new ArrayList<>();

    public ParkingFloor(String name, int Motor, int stdCount, int largeCount,int evCount) {
        this.floorName = name;
        // 1. 建立小型位 (Motorcycle)
        for (int i = 1; i <= Motor; i++) {
            spots.add(new RegularSpot(name + "-M" + String.format("%02d", i), "Motor"));
        }
        // 2. 建立標準位 (Sedan / SUV)
        for (int i = 1; i <= stdCount; i++) {
            spots.add(new RegularSpot(name + "-S" + String.format("%02d", i), "Standard"));
        }
        // 3. 建立大型位 (Truck)
        for (int i = 1; i <= largeCount; i++) {
            spots.add(new RegularSpot(name + "-L" + String.format("%02d", i), "Large"));
        }
        // 4. 建立電動車位 (EV)
        for (int i = 1; i <= evCount; i++) {
            spots.add(new RegularSpot(name + "-EV" + String.format("%02d", i), "EV"));
        }
    }

    public String getFloorName() {
        return floorName;
    }
    /**
     * 作用：讓 ParkingManager 可以取得該樓層的所有車位進行檢查
     */
    public List<ParkingSpot> getSpots() {
        return spots;
    }
    /**
     * 專門為貨車設計：尋找連續的空位
     */
    public List<ParkingSpot> findConsecutiveEmptySpots(String targetType, int count) {
        for (int i = 0; i <= spots.size() - count; i++) {
            boolean match = true;
            List<ParkingSpot> candidateSpots = new ArrayList<>();

            for (int j = 0; j < count; j++) {
                ParkingSpot current = spots.get(i + j);
                // 檢查：1. 是否為空 2. 類型是否符合 (Large)
                if (!current.isEmpty() || !current.getSpotType().equals(targetType)) {
                    match = false;
                    break;
                }
                candidateSpots.add(current);
            }

            if (match) {
                return candidateSpots; // 找到連續的位子了
            }
        }
        return null; // 該層樓沒有連續空位
    }

    // 找該樓層的空位 (回傳第一個空位，若無則回傳 null)
    public ParkingSpot findEmptySpotOnFloor(String targetType) {
        for (ParkingSpot s : spots) {
            if (s.isEmpty() && s.getSpotType().equals(targetType))
                return s;
        }
        return null;
    }
}