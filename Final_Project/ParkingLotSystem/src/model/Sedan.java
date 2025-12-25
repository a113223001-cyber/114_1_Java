package model;

// 建立子類別
public class Sedan extends Vehicle {
    public Sedan(String plate) { super(plate); }
    @Override public String getType() { return "轎車"; }
}