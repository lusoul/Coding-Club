package com.caden.designpattern.filteringiterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Iterator iter = new MyIterator();
        IObjectTest myTest = new IObjectTestImpl();
        FilteringIterator fIter = new FilteringIterator(iter, myTest);
        while (fIter.hasNext()) {
            Location loc = (Location)fIter.next();
            System.out.println(loc.getLongitude() + " " + loc.getLatitude());
        }
    }
}
