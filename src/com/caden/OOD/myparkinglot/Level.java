package com.caden.OOD.myparkinglot;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int floor;//相当于id
    private List<ParkingSpot> spots = new ArrayList<>();//一对多关系
    private int availableSpotsNum;
    private final static int TOTAL_SPOTS = 20;
    //一个level可以有很多row，每个row里面有多个spot，这样就多了一个row对象，为了方便，这里直接就一个level就一排spot就好了

    public Level(int floor) {
        this.floor = floor;
        this.availableSpotsNum = TOTAL_SPOTS;
    }
    public int getFloor() {
        return floor;
    }

    public void setAvailableSpotsNum(int num) {
        this.availableSpotsNum = num;
    }
    public int getAvailableSpotsNum() {
        return availableSpotsNum;
    }

    public void park(Vehicle v) {

    }
    public void freed(Vehicle v) {

    }

}
