// model/Vehicle.java
package model;
// 建立父類別
public abstract class Vehicle {
    protected String plate;
    public Vehicle(String plate) { this.plate = plate; }
    public String getPlate() { return plate; }
    public abstract String getType();
}