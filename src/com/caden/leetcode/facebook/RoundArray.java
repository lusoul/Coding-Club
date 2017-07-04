package com.caden.leetcode.facebook;

/**
 * Created by lusoul on 2017/4/2.
 */
public class RoundArray<T> {
    private T[] items;
    private int pos;
    private int available;
    private int capacity;;

    public RoundArray(int capactiy) {
        this.capacity = capactiy;
        items = (T[])new Object[capactiy];
        this.pos = 0;
        this.available = 0;
    }

    public void put(T t) {
        items[pos++] = t;
        if (available < capacity) {
            available++;
        }
        if (pos >= capacity) {
            pos = 0;
        }
    }
    public T get() {
        if (available == 0) return null;
        return (T)new Object();
    }


}
