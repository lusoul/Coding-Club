package com.caden.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Test5 {
    public static void main(String[] args) {
        String s = "134.9";
        String[] ss = s.split("\\.");

        System.out.println(ss.length);
        for (String sss : ss) {
            System.out.println(sss);
        }

        /*
        {0.2,0.5,1.1,1.4,2.5,2.8,3.4,3.9,4.7} -> 4
        {3.1,3.2,3.3,4.1,4.2} -> 2
        {2.1,2.2,2.5,3.2,4.3,5.0,5.2} -> 3
         */
//        double[] A = {3.1,3.2,3.3,4.1,4.2};
//        System.out.println(count(A));
    }

    public static int count(double[] A) {
        double rightWall = A[0] + 1;
        double rightCandidate = A[0] + 1;
        int count = 1;
        for (int i = 0; i < A.length; i++) {
//            if (A[i] < rightWall && A[i] + 1 > rightCandidate) {
//                rightCandidate = A[i] + 1;
//            }
            if (A[i] > rightWall) {
                rightWall = A[i] + 1;
//                rightCandidate = A[i] + 1;
                count++;
            }
        }
        return count;
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


