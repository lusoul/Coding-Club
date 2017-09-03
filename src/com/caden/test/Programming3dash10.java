package com.caden.test;

public class Programming3dash10 {

    public static void main(String[] args) {
        int number = 0;
        showIntor(number); //值传递
        System.out.println(number); // 0

        StringBuilder sb = new StringBuilder("hello");
        showIntor2(sb); //引用传递
        System.out.println(sb);
    }


    public static void showIntor(int number) {
        number = 6;
    }

    public static void showIntor2(StringBuilder sb2) {
//        sb2 = new StringBuilder("world");
        sb2.append(" world");
    }

}

// 函数 function
// 方法 method
