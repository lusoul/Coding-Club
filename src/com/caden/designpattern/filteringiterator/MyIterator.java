package com.caden.designpattern.filteringiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyIterator implements Iterator {
    private List<Location> list = new ArrayList<Location>();
    private int idx = 0;

    public MyIterator() {
        list.add(new Location(100.0, 89.1));
        list.add(new Location(-100.0, 89.1));
        list.add(new Location(123.0, -89.1));
        list.add(new Location(-100.0, -89.1));

//        list.add(new Location(127.999, -10.931));
//        list.add(new Location(-100.0, -89.1));
//        list.add(new Location(-100.0, -89.1));
//        list.add(new Location(-100.0, -89.1));
    }

    public boolean hasNext() {
        return idx != list.size();
    }

    public Location next() {
        Location ret = list.get(idx++);
        return ret;
    }

    public void remove() {

    }
}
