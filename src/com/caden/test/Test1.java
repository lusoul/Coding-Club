package com.caden.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;



public class Test1 {
    static boolean ready;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!ready) {

                }
                System.out.println("hello");
            }
        });

        String s = "a";
        s.toLowerCase();

        t1.start();
        ready = true;
        t1.join();
    }

}


