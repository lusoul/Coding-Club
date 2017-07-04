package com.caden.OOD.Elevator;

public class User {
    float weight;
    public void pressButton(int floor) {
        Request request = new Request(floor);
        RequestCenter rc = RequestCenter.getInstance();
        rc.add(request);
    }
}
