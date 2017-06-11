package com.caden.leetcode.amazon.OA;

import java.util.ArrayList;
import java.util.List;

/**
 * I: 这是OA2 判断两个数是不是gray code （easy）
 *
 * II: leetcode上的，给n表示total number of bit,输出所有gray code集合，背公式 i ^ (i >> 1)
 * */
public class GrayCode {
    public static void main(String[] args) {
        SolutionGrayCode s = new SolutionGrayCode();
        byte num1 = (byte)136;//10001000
        byte num2 = (byte)152;//10011000
        System.out.println(s.isGrayCodeI(num1, num2));
    }
}

class SolutionGrayCode {
    public boolean isGrayCodeI(byte num1, byte num2) {
        //1.先求亦或后的结果再数1出现的个数，如果1出现超过1次就return false
        byte num = (byte)(num1 ^ num2);//注意这里要转换！
        int total = 0;
        while (num != 0) {
            num = (byte)(num - (num & (-num)));
            total++;
            if (total > 1) return false;
        }
        return true;
    }

    public List<Integer> getAllGrayCodeII(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            ret.add(i ^ (i >> 1));
        }
        return ret;
    }
}

