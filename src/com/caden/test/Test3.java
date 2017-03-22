package com.caden.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        Iterator iter = new MyIterator();
//        while (iter.hasNext()) {
//            Location loc = (Location)iter.next();
//            System.out.println(loc.getLongitude() + " " + loc.getLatitude());
//        }
        System.out.println("-------------");
        IObjectTest myTest = new IObjectTestImpl();
        FilteringIterator fIter = new FilteringIterator(iter, myTest);
        while (fIter.hasNext()) {
            Location loc = fIter.next();
            System.out.println(loc.getLongitude() + " " + loc.getLatitude());
        }
    }
}

interface IObjectTest {
    boolean test(Location obj);
}
class IObjectTestImpl implements IObjectTest {
    @Override
    public boolean test(Location obj) {
        if (null == obj) return false;
        if (obj instanceof Location) {
            Location location = (Location)obj;
            //condition: get location longitude range is [0, 180], latitude range is [-90, 0]
            if (location.getLongitude() >= 0.0 && location.getLongitude() <= 180
                    && location.getLatitude() <= 0 && location.getLatitude() >= -90) {
                return true;
            }
        }
        return false;
    }
}

class FilteringIterator implements Iterator {
    private IObjectTest filter;
    private Iterator iterator;

    private Location next;

    public FilteringIterator(Iterator myIterator, IObjectTest myTest) {
        filter = myTest;
        iterator = myIterator;
        findNext();//初始化时就定位到一个合法位置
    }

    private void findNext() {
        while (iterator.hasNext()) {
            this.next = (Location) iterator.next();
            if (null == filter || filter.test(this.next)) {
                return;
            }
        }
        this.next = null;//这句很重要
    }

    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public Location next() {
        Location ret = this.next;
        this.findNext();
        return ret;
    }
}


class Location {
    private double longitude;
    private double latitude;
    public Location() {}
    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public double getLongitude() {
        return this.longitude;
    }
    public double getLatitude() {
        return this.latitude;
    }
}

class MyIterator implements Iterator {

    private List<Location> list = new ArrayList<>();
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

    @Override
    public boolean hasNext() {
        return idx != list.size();
    }

    @Override
    public Location next() {
        Location ret = list.get(idx++);
        return ret;
    }
}