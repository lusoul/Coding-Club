package com.caden.test;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Virtual Studio Team");
        map.put(2, "The Office 365 Group");
        Random rd = new Random();
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(1, 0);
        freq.put(2, 0);
        Map<Integer, Integer> count = new HashMap<>();
        count.put(1, 0);
        count.put(2, 0);

        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < 100000000; i++) {
                int rdNum = rd.nextInt(1000) + 1;
                if (rdNum > 500) freq.put(2, freq.get(2) + 1);
                else freq.put(1, freq.get(1) + 1);

//                if (freq.containsKey(rdNum)) freq.put(rdNum, freq.get(rdNum) + 1);
            }
            if (freq.get(1) > freq.get(2)) {
                count.put(1, count.get(1) + 1);
            } else {
                count.put(2, count.get(2) + 1);
            }
            System.out.println(freq.get(1));
            System.out.println(freq.get(2));

            System.out.println("---------");
        }
        System.out.println(count.get(1));
        System.out.println(count.get(2));
        if (count.get(1) > count.get(2)) System.out.println(map.get(1));
        else System.out.println(map.get(2));
    }
}

