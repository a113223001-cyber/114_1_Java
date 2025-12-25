package model;

// 建立子類別
public class Motorcycle extends Vehicle {
    public Motorcycle(String plate) { super(plate); }
    @Override public String getType() { return "機車"; }
}