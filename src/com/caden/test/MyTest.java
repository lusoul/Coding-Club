package com.caden.test;

public class MyTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.foo(5));
    }
}

class Solution {
    public int foo(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        return x + foo(x - 1);
    }
}
