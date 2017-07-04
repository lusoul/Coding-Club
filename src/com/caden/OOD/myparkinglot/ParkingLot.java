package com.caden.OOD.myparkinglot;

//停车场有行为：查询是否有合适的空位可以停当前的车；将当前的车与指定ParkingSpot匹配起来，实际是根据Level来匹配，Level下面才是spots，
// 所以level也要有这方法；车子离开以后对ParkingSpot进行还原
public class ParkingLot {
    private String address;
    private final static int TOTAL_SPOT = 100;
    private int availableSpotNum;

    private Level[] levels;//一个停车场有多层
    private final static int TOTAL_LEVEL = 10;

    public ParkingLot(String address) {
        this.address = address;
        availableSpotNum = TOTAL_SPOT;
        levels = new Level[TOTAL_LEVEL];
    }

    public boolean isAvaiable(Vehicle v) {
        // 通过车辆大小来查询停车场内是否还有空位
        return false;
    }

    public void park(Vehicle v) {
        // 有空位可以停车,根据车子信息判断改变availableSpotNum的值
        // 会查询楼层信息level，然后根据level里的spot list来查找车位
        // 将spot信息设置给vehicle变量，所以vehicle变量需要维护spot信息
    }
    public void freed(Vehicle v) {
        // 这辆车离开，
    }
}
