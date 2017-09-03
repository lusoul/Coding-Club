package com.caden.test;

public class TTTT {
    public static void main(String[] args) {
        System.out.println(getOnesCount(11));
    }

    public static int getOnesCount(int n) {
        if (n < 0) return 0;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            //current number i
            int count = 0;
            int num = i;
            while (num > 0) {
                if (num % 10 == 1) count++;
                num /= 10;
            }
            res += count;
        }
        return res;
    }
}
