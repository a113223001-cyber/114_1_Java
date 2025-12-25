package model;

// 建立子類別
public class ElectricCar extends Vehicle {
    public ElectricCar(String plate) { super(plate); }
    @Override public String getType() { return "電動車"; }
}