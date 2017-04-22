package com.caden.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test6 {
    public static void main(String[] args) {
        int[] ascII = new int[256];
        char c = 'a';
        ascII[c] = 5;
        System.out.println(ascII['a']);
    }
}