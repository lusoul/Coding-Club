package com.caden.OOD.parkinglot;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level level, int row, int spotNumber, VehicleSize size) {
        this.level = level;
        this.row = row;
        this.spotNumber = spotNumber;
        this.spotSize = size;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }
    //check if the spot is big enough and is available
    public boolean canFitVehicle(Vehicle vehicle) {
        return false;
    }
    // park vehicle in this spot
    public boolean park(Vehicle v) {
        return false;
    }
    public int getRow() {
        return row;
    }
    public int getSpotNumber() {
        return spotNumber;
    }
    //remove vehicle from spot, and notify level that a new spot is available
    public void removeVehicle() {
        //...
    }
}
