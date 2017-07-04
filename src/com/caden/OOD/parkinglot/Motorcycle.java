package com.caden.OOD.parkinglot;

public class Motorcycle extends Vehicle {

    public Motorcycle(String vinNum) {
        this.vinNum = vinNum;
        this.size = VehicleSize.Motorcycle;
        this.spotNeeded = 1;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }
}
