package com.caden.OOD.parkinglot;

public class Car extends Vehicle {
    public Car(String vinNum) {
        this.spotNeeded = 1;
        this.size = VehicleSize.Compact;
        this.vinNum = vinNum;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        // check spot is compact or large
        return false;
    }
}
