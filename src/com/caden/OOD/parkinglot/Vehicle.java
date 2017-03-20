package com.caden.OOD.parkinglot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    protected VehicleSize size;
    protected String vinNum;
    protected int spotNeeded;
    protected List<ParkingSpot> parkingSpots = new ArrayList<>();

    public int getSpotsNeeded() {
        return this.spotNeeded;
    }
    public VehicleSize getSize() {
        return this.size;
    }
    public void parkInSpot(ParkingSpot spot) {
        this.parkingSpots.add(spot);
    }
    public abstract boolean canFitInSpot(ParkingSpot spot);
}
