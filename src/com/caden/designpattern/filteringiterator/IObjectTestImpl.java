package com.caden.designpattern.filteringiterator;

/**
 * Created by Caden on 2017/3/21.
 */
public class IObjectTestImpl<E> implements IObjectTest<E> {
    public boolean test(E e) {
        if (null == e) return false;
        if (e instanceof Location) {
            Location location = (Location)e;
            //condition: get location longitude range is [0, 180], latitude range is [-90, 0]
            if (location.getLongitude() >= 0.0 && location.getLongitude() <= 180
                    && location.getLatitude() <= 0 && location.getLatitude() >= -90) {
                return true;
            }
        }
        return false;
    }
}
