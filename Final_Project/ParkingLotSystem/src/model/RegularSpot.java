package model;

// 建立子類別
public class RegularSpot extends ParkingSpot {
    public RegularSpot(String id, String type) {
        super(id,type); // 呼叫父類別 ParkingSpot 的建構子
    }
}