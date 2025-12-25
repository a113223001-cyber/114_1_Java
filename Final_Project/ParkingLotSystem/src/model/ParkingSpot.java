// model/ParkingSpot.java
package model;

import java.time.LocalDateTime;

public abstract class ParkingSpot {
    private String spotId;
    private String spotType;      // 新增：用於區分 "Small", "Standard", "Large","Electric"
    private Vehicle parkedVehicle; // 預設就是 null
    private LocalDateTime startTime;

    public ParkingSpot(String id, String type) {
        this.spotType = type; // 設定車位類型
        this.spotId = id;
    }
    public String getSpotType() { return spotType; }// 取得車位類型
    // 如果車子是 null，就代表是空的
    public boolean isEmpty() {
        return parkedVehicle == null;
    }

    public void park(Vehicle v) {
        this.parkedVehicle = v;
        this.startTime = LocalDateTime.now();
    }

    public void leave() {
        this.parkedVehicle = null;
        this.startTime = null;
    }

    // Getter 方法
    public Vehicle getParkedVehicle() { return parkedVehicle; }
    public String getSpotId() { return spotId; }
    public LocalDateTime getStartTime() { return startTime; }
}