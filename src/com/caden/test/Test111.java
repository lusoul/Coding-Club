package com.caden.test;

public class Test111 {
    public static void main(String[] args) {

        // i: 1,  2,  3,  .... 30
        //   30  29  28
        //  31-i

        int sum = 0;
        for (int i = 1, j = 30; i <= 30 && j > 0; i++, j--) {
            sum += i / j;
        }
        System.out.println(sum);

    }
}
