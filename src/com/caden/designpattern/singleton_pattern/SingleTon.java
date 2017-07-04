package com.caden.designpattern.singleton_pattern;

public class SingleTon {
    public static volatile SingleTon instance;
    private SingleTon() {};

    public static SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }
}
