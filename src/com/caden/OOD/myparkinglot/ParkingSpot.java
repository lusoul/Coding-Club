package com.caden.OOD.myparkinglot;

//spot不应该有什么行为
public class ParkingSpot {
    private int spotId;
    private boolean taken;
    private VehicleSize size;

    public ParkingSpot(int spotId) {
        this.spotId = spotId;
    }

    public int getSpotId() {
        return this.spotId;
    }
    public void setTaken(boolean taken) {
        this.taken = taken;
    }
    public boolean isTaken() {
        return this.taken;
    }
    public VehicleSize getSize() {
        return size;
    }
}
