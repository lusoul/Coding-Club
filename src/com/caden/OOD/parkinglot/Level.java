package com.caden.OOD.parkinglot;

public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;// number of free spots
    private static final int SPORTS_PER_ROW = 10;

    public Level(int floor, int numberSpots) {
        //...
    }
    public int availableSpots() {
        return availableSpots;
    }
    public boolean parkVehicle(Vehicle vehicle) {
        return false;
    }
    //park a vehicle starting at the spot sportNumber, and continuing until vehicle.spotsNeeded
    private boolean parkStartingAtSpot(int num, Vehicle v) {
        return false;
    }
    // find a spot to park this vehicle, return index of spot, or -1 on failure
    private int findAvailableSpots(Vehicle v) {
        return 0;
    }
    // when a car was removed from the spot, increment available spots
    public void spotFreed() {
        availableSpots++;
    }

}
