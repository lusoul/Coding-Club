package com.caden.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test5 {
    public static void main(String[] args) {
        int[] A = {6,2,3,4,5};
        SolutionWWQ s = new SolutionWWQ();
        System.out.println(Float.MIN_VALUE > 0);
        double d = 0;
        List<Character>[] arr = new ArrayList[5];
        System.out.println(arr[0].size());
//        String str = s.optimalDivision(A);
//        System.out.println(str);
//        System.out.println(Double.MIN_VALUE);
//        System.out.println(Double.MAX_VALUE);
    }
}

class SolutionWWQ {
    public String optimalDivision(int[] nums) {
        return "";
    }

    private ResultType search(int[] A, int start, int end) {
        if (start == end) {
            ResultType rs = new ResultType();
            rs.minVal = rs.maxVal = A[start];
            rs.minPath = rs.maxPath = A[start] + "";
            return rs;
        }
        return null;
    }

    class ResultType {
        double minVal, maxVal;
        String minPath, maxPath;
    }
}





