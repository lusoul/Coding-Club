package com.caden.OOD.Elevator;

/**
 * 也是单例，因为就只有一个电梯
 */
public class Elevator {
    int curFloor;
    private static final float CAPACITY = 1000;//1000 pounds
    float curWeight;

    private static volatile Elevator instance;
    private Elevator() {
        this.curFloor = 0;
        this.curWeight = 0;
    }
    public static Elevator getInstance() {
        if (instance == null) {
            synchronized (Elevator.class) {
                if (instance == null) {
                    instance = new Elevator();
                }
            }
        }
        return instance;
    }

    public void moveToTargetFloor(int floor) {
        while (floor < curFloor) {
            moveDown();
        }
        while (floor > curFloor) {
            moveUp();
        }
    }
    private void moveUp() {
        curFloor++;
    }
    private void moveDown() {
        curFloor--;
    }
}
