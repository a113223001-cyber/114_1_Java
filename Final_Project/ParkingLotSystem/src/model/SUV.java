package model;

// 建立子類別
public class SUV extends Vehicle {
    public SUV(String plate) { super(plate); }
    @Override public String getType() { return "轎車"; }
}