package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class MergeInterval {
    public static void main(String[] args) {
        MyInterval interval = new MyInterval(1, 3);
        MyInterval interval2 = new MyInterval(2,6);
        MyInterval interval3 = new MyInterval(8,10);
        MyInterval interval4 = new MyInterval(15,18);
        List<MyInterval> list = new ArrayList<>();
        list.add(interval);list.add(interval2);list.add(interval3);list.add(interval4);
        SolutionMergeInterval s = new SolutionMergeInterval();
        List<MyInterval> ret = s.merge(list);
        for (MyInterval inter : ret) {
            System.out.println(inter.start + " " + inter.end);
        }
    }
}


class MyInterval {
      int start;
      int end;
    MyInterval() { start = 0; end = 0; }
    MyInterval(int s, int e) { start = s; end = e; }
}
class SolutionMergeInterval {
    class Point {
        int val;
        boolean start;
        public Point(int val, boolean start) {
            this.val = val;
            this.start = start;
        }
    }
    public List<MyInterval> merge(List<MyInterval> intervals) {
        List<MyInterval> ret = new ArrayList<>();
        List<Point> points = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return ret;
        for (MyInterval interval : intervals) {
            points.add(new Point(interval.start, true));
            points.add(new Point(interval.end, false));
        }
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.val == p2.val) {
                    if (p1.start == p2.start) return 0;
                    if (p1.start) return -1;
                    else return 1;
                }
                return p1.val - p2.val;
            }
        });
        int count = 0, startIdx = 0;
        for (Point point : points) {
            if (point.start) count++;
            if (count == 1 && point.start) startIdx = point.val;
            if (!point.start) count--;
            if (count == 0 && !point.start) {
                MyInterval inter = new MyInterval(startIdx, point.val);
                ret.add(inter);
            }
        }
        return ret;
    }
}

