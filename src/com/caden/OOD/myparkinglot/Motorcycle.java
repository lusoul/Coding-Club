package com.caden.OOD.myparkinglot;

public class Motorcycle extends Vehicle {
    public Motorcycle(String plateNum) {
        this.plateNum = plateNum;
        this.size = VehicleSize.Motorcycle;
        this.spotNeeded = 1;
    }
}
