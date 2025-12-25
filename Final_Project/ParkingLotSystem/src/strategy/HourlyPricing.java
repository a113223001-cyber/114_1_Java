package strategy;

import model.Vehicle;
import java.time.Duration;

public class HourlyPricing extends PricingStrategy {
    @Override
    public double calculateFee(Duration duration, Vehicle vehicle) {
        // 1. 不滿 1 小時算 1 小時
        long totalHours = duration.toHours();
        if (duration.toMinutes() % 60 > 0) {
            totalHours++;
        }

        // 2. 進行累進計費計算
        double totalFee = 0;

        if (totalHours <= 20) {
            // 前 20 小時，每小時 40 元
            totalFee = totalHours * baseRate;
        } else {
            // 第 21 小時起，每小時 60 元
            // 計算方式：(前 20 小時固定費用) + (超過 20 小時的部分 * 60)
            double baseFee = 20 * baseRate; // 20 * 40 = 800
            double penaltyFee = (totalHours - 20) * penaltyRate;
            totalFee = baseFee + penaltyFee;
        }

        // 3. 根據車種調整費用

        // 貨車佔了兩格標準位
        if (vehicle instanceof model.Truck) {
            totalFee *= 2.0; // 既然佔兩格標準位，收雙倍很合理
        }

        // 休旅車停大型位
        if (vehicle instanceof model.SUV) {
            totalFee *= 1.5; // 大型位比較貴，收 1.5 倍
        }
        // 如果是電動車，每小時加收 20 元充電服務費
        if (vehicle instanceof model.ElectricCar) {
            // 充電費 = 小時數 * 20 元
            double chargingServiceFee = totalHours * 20;
            totalFee += chargingServiceFee;
        }

        return totalFee;
    }


    @Override
    public String getDescription() {
        return "累進計費：前20小時 40/hr，之後 60/hr (不足1小時以1小時計)";
    }
}