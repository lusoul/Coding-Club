package com.caden.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Test5 {
    public static void main(String[] args) {
//        System.out.println(sqrt(8));
        int[] A = {1,1,2,3,2};//,2,3,2};

        int time = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);

        boolean setToZero = false;
        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) == 0) {
                time++;
                map.put(A[i], 2);
                setToZero = false;
            } else {
                time = time + map.get(A[i]) + 1;
                setToZero = true;
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() != A[i] && entry.getValue() != 0) {
                    if (setToZero) {
                        entry.setValue(0);
                    } else {
                        entry.setValue(entry.getValue() - 1);
                    }
                }
            }
        }
        System.out.println(time);

    }

    public static float sqrt(int target) {
        float start = 0, end = target;
        while (start + 1e-2 < end) {
            float mid = start + (end - start) / 2;
            if (mid * mid <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        float ret = 0;
        if (end * end <= target) ret = end;
        else ret = start;

        BigDecimal bd = new BigDecimal(ret);
        bd = bd.setScale(2, BigDecimal.ROUND_DOWN);
        return bd.floatValue();
    }
}


