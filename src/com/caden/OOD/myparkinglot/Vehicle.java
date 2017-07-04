package com.caden.OOD.myparkinglot;

import java.util.ArrayList;
import java.util.List;

//车子有属性，有行为，行为就是停车和开走
public abstract class Vehicle {
    protected String plateNum;
    protected VehicleSize size;
    protected int spotNeeded;
    protected List<ParkingSpot> spots = new ArrayList<>();//因为停车或离开，都要通过vehicle信息来获得他停车位信息，为什么list，因为bus会占用5个车位

    public VehicleSize getSize() {
        return this.size;
    }
    public String getPlateNum() {
        return this.plateNum;
    }
    public int getSpotNeeded() {
        return this.spotNeeded;
    }

    public void park(ParkingSpot spot) {
        spot.setTaken(true);
        this.spots.add(spot);
    }
    public void depart() {
        for (ParkingSpot spot : spots) {
            spot.setTaken(false);
            this.spots.remove(spot);
        }
    }

//    public abstract boolean canFitInSpot()
}
