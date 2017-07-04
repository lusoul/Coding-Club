package com.caden.OOD.Elevator;

import java.util.ArrayList;
import java.util.List;

//需要单例模式
public class RequestCenter implements Runnable {
    private static volatile RequestCenter instance;

    List<Request> list;
    private RequestCenter() {
        list = new ArrayList<>();
    }
    public static RequestCenter getInstance() {
        if (instance == null) {
            synchronized (RequestCenter.class) {
                if (instance == null) {
                    instance = new RequestCenter();
                }
            }
        }
        return instance;
    }

    public void add(Request rq) {
        list.add(rq);
    }
    public void remove(Request rq) {
        list.remove(rq);
    }
    public void processRequest() {
        if (list.isEmpty()) return;
        Elevator elevator = Elevator.getInstance();
        int shortest = Integer.MAX_VALUE;
        Request targetRequest = list.get(0);
        for (Request rq : list) {
            if (Math.abs(rq.floor - elevator.curFloor) < shortest) {
                shortest = Math.abs(rq.floor - elevator.curFloor);
                targetRequest = rq;
            }
        }
        elevator.moveToTargetFloor(targetRequest.floor);
        list.remove(targetRequest);
    }

    @Override
    public void run() {
        while (true) {
            processRequest();
        }
    }
}

