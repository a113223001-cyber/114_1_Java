package strategy;

import model.Vehicle;
import java.time.Duration;

public abstract class PricingStrategy {
    //基本小時費率
    // 定義基礎費率
    protected double baseRate = 40.0;// 前20小時的費率
    protected double penaltyRate = 60.0;// 超過20小時後的費率

    // 抽象方法：由子類別決定怎麼算錢
    public abstract double calculateFee(Duration duration, Vehicle vehicle);

    // 普通方法：所有計費方案都共用的描述功能
    public abstract String getDescription();
}