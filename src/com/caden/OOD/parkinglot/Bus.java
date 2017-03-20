package com.caden.OOD.parkinglot;

public class Bus extends Vehicle {

    public Bus(String vinNum) {
        this.spotNeeded = 5;
        this.size = VehicleSize.Large;
        this.vinNum = vinNum;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        // check if spot is large, doesn't check num of spots
        return false;
    }
}
