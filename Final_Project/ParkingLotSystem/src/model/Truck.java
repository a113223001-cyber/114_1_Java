package model;

// 建立子類別
public class Truck extends Vehicle {
    public Truck(String plate) { super(plate); }
    @Override public String getType() { return "轎車"; }
}