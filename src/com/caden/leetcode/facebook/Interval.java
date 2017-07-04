package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 找出 一个 time stamp  出现在interval的次数最多。
 startTime <= t< stopTime 代表这个数在区间里面出现过。
 example：  [1,3),  [2, 7),   [4,  8),   [5, 9)
 5和6各出现了三次， 所以答案返回5，6。
 */
public class Interval {
    public static void main(String[] args) {
        int[][] A = {{1,3},{2,7},{4,8},{5,9}};
        Interval in = new Interval();
        List<Integer> ret = in.getMostTimestamp(A);
        for (Integer i : ret) {
            System.out.println(i);
        }
    }
    class Point {
        int val;
        boolean start;
        public Point(int val, boolean start) {
            this.val = val;
            this.start = start;
        }
    }

    public List<Integer> getMostTimestamp(int[][] times) {
        List<Integer> ret = new ArrayList<>();
        if (times == null || times.length == 0) return ret;
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            Point p1 = new Point(times[i][0], true);
            Point p2 = new Point(times[i][1], false);
            points.add(p1);
            points.add(p2);
        }
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.val < p2.val) {
                    return -1;
                } else if (p1.val > p2.val) {
                    return 1;
                } else {
                    if (p1.start && p2.start) {
                        return 0;
                    } else if (p1.start) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        int count = 0, max = 0;
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).start) {
                count++;
                if (count < max) continue;

                if (count > max) {
                    max = count;
                    ret.clear();
                }
                int offset = 0;
                if (i < points.size() - 1) {
                    offset = points.get(i + 1).val - points.get(i).val - 1;
                }
                for (int j = points.get(i).val; j <= points.get(i).val + offset; j++) {
                    ret.add(j);
                }

            } else {
                count--;
            }
        }
        return ret;
    }
}
