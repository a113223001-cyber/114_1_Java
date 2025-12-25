package system;

import model.ParkingSpot;
import model.Vehicle;
import model.Motorcycle;
import model.Truck;
import model.ElectricCar;
import java.util.ArrayList;
import java.util.List;


public class ParkingManager {
    // 現在管理的是「樓層清單」
    private List<ParkingFloor> floors = new ArrayList<>();
    public ParkingManager() {
        // 初始化兩個樓層
        floors.add(new ParkingFloor("B1",3,6,8,3));// B1: 3小 5標 2大
        floors.add(new ParkingFloor("B2", 3,6,8,3  ));// B2: 5小 5標 0大
    }
    // 在 system/ParkingManager.java 類別中新增這個方法
    public int getAvailableCountByType(String type) {
        int count = 0;
        for (ParkingFloor floor : floors) {
            for (ParkingSpot s : floor.getSpots()) {
                // 同時滿足：1.位子是空的 2.型態標籤吻合 (Small/Standard/Large)
                if (s.isEmpty() && s.getSpotType().equals(type)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 核心功能：根據車種尋找適合的空位
     * 作用：根據傳入的車輛類型，尋找相符的空位
     */
    public Object findEmptySpot(Vehicle v) {
        // 1. 機車：找 1 格小型位
        if (v instanceof model.Motorcycle) {
            for (ParkingFloor floor : floors) {
                ParkingSpot spot = floor.findEmptySpotOnFloor("Motor");
                if (spot != null) return spot;
            }
        }
        // 2. 貨車：找 2 格連續「標準位」
        else if (v instanceof model.Truck) {
            for (ParkingFloor floor : floors) {
                List<ParkingSpot> spots = floor.findConsecutiveEmptySpots("Standard", 2);
                if (spots != null) return spots;
            }
        }
        // 3. 休旅車：找 1 格大型位
        else if (v instanceof model.SUV) {
            for (ParkingFloor floor : floors) {
                ParkingSpot spot = floor.findEmptySpotOnFloor("Large");
                if (spot != null) return spot;
            }
        }
        // 4. 轎車：找 1 格標準位
        else if (v instanceof model.Sedan) {
            for (ParkingFloor floor : floors) {
                ParkingSpot spot = floor.findEmptySpotOnFloor("Standard");
                if (spot != null) return spot;
            }

            return null; // 都沒位子
        } else if (v instanceof ElectricCar) {
            // 電動車優先找 EV 位子
            for (ParkingFloor floor : floors) {
                ParkingSpot spot = floor.findEmptySpotOnFloor("EV");
                if (spot != null) return spot;
            }
            // 如果 EV 位子滿了，電動車通常也可以停 Standard 位子
            for (ParkingFloor floor : floors) {
                ParkingSpot spot = floor.findEmptySpotOnFloor("Standard");
                if (spot != null) return spot;
            }
        }
        return null;
    }

    /**
     * 釋放特定車牌佔用的所有位子 (支援貨車一次釋放兩格)
     */
    public void releaseAllSpotsByPlate(String plate) {
        for (ParkingFloor floor : floors) {
            for (ParkingSpot s : floor.getSpots()) {
                if (!s.isEmpty() && s.getParkedVehicle() != null) {
                    if (s.getParkedVehicle().getPlate().equalsIgnoreCase(plate)) {
                        s.leave();
                    }
                }
            }
        }
    }


    /**
     * 檢查車牌是否重複
     * 作用：遍歷所有樓層的所有車位，看有沒有一樣的車牌
     */
    public boolean isPlateAlreadyParked(String plate) {// 輸入要檢查的車牌
        for (ParkingFloor floor : floors) {// 逐層檢查
            for (ParkingSpot s : floor.getSpots()) {// 逐個車位檢查
                // 如果車位不為空，且車牌與輸入相同
                if (!s.isEmpty() && s.getParkedVehicle() != null) {// 防空值檢查
                    if (s.getParkedVehicle().getPlate().equalsIgnoreCase(plate)) {// 忽略大小寫比較*
                        return true; // 發現重複車牌
                    }
                }
            }
        }
        return false; // 沒有重複
    }


    /**
     * 根據車牌搜尋車位 (離場結帳用)
     */
    public ParkingSpot findSpotByPlate(String plate) {
        for (ParkingFloor floor : floors) {
            for (ParkingSpot s : floor.getSpots()) {
                if (!s.isEmpty() && s.getParkedVehicle() != null) {
                    if (s.getParkedVehicle().getPlate().equals(plate)) {
                        return s;
                    }
                }
            }
        }
        return null;
    }

    // 回傳所有樓層，供 Main 顯示狀態
    public List<ParkingFloor> getFloors() {
        return floors;
    }
}