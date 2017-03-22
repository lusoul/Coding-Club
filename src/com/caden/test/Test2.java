//package com.caden.test;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class Test2 {
//    public static void main(String[] args) {
//        Iterator iter = new MyIterator();
////        while (iter.hasNext()) {
////            Location loc = (Location)iter.next();
////            System.out.println(loc.getLongitude() + " " + loc.getLatitude());
////        }
//        System.out.println("-------------");
//        IObjectTest myTest = new IObjectTestImpl();
//        FilteringIterator fIter = new FilteringIterator(iter, myTest);
//        while (fIter.hasNext()) {
//            Location loc = fIter.next();
//            System.out.println(loc.getLongitude() + " " + loc.getLatitude());
//        }
//    }
//}
//
///*
//* Create an Iterator filtering framework: (1) IObjectTest interface with a single boolean test(Object o) method and 
//* (2) an implementation of Iterator (let's call it FilteringIterator) which is initialized with another Iterator
//* and an IObjectTest instance: new FilteringIterator(myIterator, myTest). Your FilteringIterator will then allow
//* iteration over 'myIterator', but skipping any objects which don't pass the 'myTest' test. Create a simple unit
//* test for this framework.
//* */
//interface IObjectTest {
//    boolean test(Location obj);
//}
//class IObjectTestImpl implements IObjectTest {
//    @Override
//    public boolean test(Location obj) {
//        if (null == obj) return false;
//        if (obj instanceof Location) {
//            Location location = (Location)obj;
//            //condition: get location longitude range is [0, 180], latitude range is [-90, 0]
//            if (location.getLongitude() >= 0.0 && location.getLongitude() <= 180
//                    && location.getLatitude() <= 0 && location.getLatitude() >= -90) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
//
//class FilteringIterator implements Iterator {
//    private IObjectTest filter;
//    private Iterator iterator;
//
//    private boolean hasNext;
//    private Location loc;
//
//    public FilteringIterator(Iterator myIterator, IObjectTest myTest) {
//        this.filter = myTest;
//        this.iterator = myIterator;
//    }
//
//    @Override
//    public boolean hasNext() {
//        return iterator.hasNext();
//    }
//
//    @Override
//    public Location next() {
//        Location ret = new Location();
//        while (iterator.hasNext()) {
//            Location val = (Location)iterator.next();
//            if (null == filter || filter.test(val)) {
//                ret = val;
//                break;
//            }
//        }
//
//        return ret;
//    }
//}
//
//
//class Location {
//    private double longitude;
//    private double latitude;
//    public Location() {}
//    public Location(double longitude, double latitude) {
//        this.longitude = longitude;
//        this.latitude = latitude;
//    }
//    public double getLongitude() {
//        return this.longitude;
//    }
//    public double getLatitude() {
//        return this.latitude;
//    }
//}
//
//class MyIterator implements Iterator {
//
//    private List<Location> list = new ArrayList<>();
//    private int idx = 0;
//
//    public MyIterator() {
//        list.add(new Location(100.0, 89.1));
//        list.add(new Location(-100.0, 89.1));
//        list.add(new Location(123.0, -89.1));
//        list.add(new Location(-100.0, -89.1));
//
////        list.add(new Location(127.999, -10.931));
////        list.add(new Location(-100.0, -89.1));
////        list.add(new Location(-100.0, -89.1));
////        list.add(new Location(-100.0, -89.1));
//    }
//
//    @Override
//    public boolean hasNext() {
//        return idx != list.size();
//    }
//
//    @Override
//    public Location next() {
//        Location ret = list.get(idx++);
//        return ret;
//    }
//}